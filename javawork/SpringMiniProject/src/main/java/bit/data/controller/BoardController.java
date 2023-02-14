package bit.data.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bit.data.dto.BoardDto;
import bit.data.service.BoardAnswerServiceInter;
import bit.data.service.BoardServiceInter;
import bit.data.service.MemberServiceInter;
import util.ChangeName;

@Controller
public class BoardController {

	@Autowired
	BoardServiceInter boardService; // boardservice나 boardserviceinter 해주면됨
	
	@Autowired
	BoardAnswerServiceInter answerService;	//boardlist에서 댓글의 개수를 가져오기위함 (dto에 담으려고)

	@Autowired
	MemberServiceInter memberService; // boarddetail 에서 작성자의 사진을 가져오려면 서비스에 접근할 수 있어야함

	@GetMapping("/board/list")
	public String board(@RequestParam(defaultValue = "1") int currentPage, // null 일 경우 기본페이지를 1로
			@RequestParam(value = "searchcolumn", required = false) String sc, // required = false : 값이 없을 경우 null
			@RequestParam(value = "searchword", required = false) String sw, Model model) {
		// Webproject > upload > smartlist 복붙
		// 페이징 처리에 필요한 변수들
		// 전체 갯수
		int totalCount = boardService.getTotalCount(sc, sw);
		int perPage = 10;// 한페이지당 보여질 글의 갯수
		int perBlock = 5;// 한블럭당 보여질 페이지의 갯수
		int startNum;// db에서 가져올 글의 시작번호(mysql은 첫글이 0번,오라클은 1번)
		int startPage;// 각블럭당 보여질 시작페이지
		int endPage;// 각 블럭당 보여질 끝페이지
//		int currentPage;//현재 페이지
		int totalPage;// 총 페이지수
		int no;// 각 페이지당 출력할 시작번호

		// 총 페이지수를 구한다
		// 총글의갯수/한페이지당보여질갯수로 나눔(7/5=1)
		// 나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

		// 각 블럭당 보여질 시작페이지
		// perBlock=5 일경우 현재페이지가 1~5 일경우는 시작페이지가 1, 끝페이지가 5
		// 만약 현재페이지가 13 일경우는 시작페이지가 11, 끝페이지가 15
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지수가 23개일경우 마지막 블럭은 끝페이지가 25가 아니라 23이라야한다
		if (endPage > totalPage)
			endPage = totalPage;

		// 각 페이지에서 보여질 시작번호
		// 예: 1페이지->0, 2페이지:5, 3페이지 : 10...
		startNum = (currentPage - 1) * perPage;

		// 각페이지당 출력할 시작번호 구하기
		// 예: 총글갯수가 23이라면 1페이지는 23,2페이지는 18,3페이지는 13...
		no = totalCount - (currentPage - 1) * perPage;

		// 페이지에서 보여질 글만 가져오기
		List<BoardDto> list = boardService.getPagingList(sc, sw, startNum, perPage);
		
		//list의 각 acount 에 댓글 갯수 저장하기
		for(BoardDto dto:list)
		{
			int acount=answerService.getAllAnswerList(dto.getNum()).size();
			dto.setAcount(acount);
		}

		// request 에 출력시 필요한 변수들을 넣어준다
		model.addAttribute("list", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("no", no);

		System.out.println("totalCount=" + totalCount);

		return "/bit/board/boardlist";
	}

	@GetMapping("/board/form")
	public String bform(@RequestParam(defaultValue = "0") int num, @RequestParam(defaultValue = "0") int regroup,
			@RequestParam(defaultValue = "0") int restep, @RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "1") int currentPage, Model model) {
		// 답글일 경우만 넘어오는값 들
		// 새글 작성의 경우는 모두 null이므로 defaultValue값으로 전달
		model.addAttribute("num", num);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("currentPage", currentPage);

		// 제목에 새글이면 "", 답글일경우 해당 원본글의 제목을 넣어보자
		String subject = "";
		if (num > 0) {
			subject = boardService.getData(num).getSubject();
		}
		model.addAttribute("subject", subject);

		return "/bit/board/boardform";
	}

	@PostMapping("/board/insert") // 이미지 들어있으면 무조건 postMapping
	public String insert(BoardDto dto, int currentPage, List<MultipartFile> upload, HttpServletRequest request)
	// currentpage가 반드시 넘어오므로 RequestParam안해도됨
	{

		// 업로드 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		// 경로 확인
		System.out.println(path);

		// 업로드를 안했을 경우 0번지의 파일명이 null이 아닌 ""(빈문자열)이 된다
		// 업로드를 안해도 upload size가 1이 된다
		System.out.println(upload.size());

		if (upload.get(0).getOriginalFilename().equals("")) { // 빈문자열이면 업로드를 안했을때

			dto.setPhoto("no");
		} else {
			String photo = "";

			// 파일명이 동일해지는것 방지하기 (mutliple 인 경우)
			int idx = 1;

			for (MultipartFile multi : upload) {
				// 파일명을 현재 날짜로 변경하고 컴마(,) 로 연결
				String newName = idx++ + "_" + ChangeName.getChangeFileName(multi.getOriginalFilename());
				photo += newName + ",";

				// 업로드
				try {
					multi.transferTo(new File(path + "/" + newName));
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 마지막 컴마 제거
			photo = photo.substring(0, photo.length() - 1);

			// dto에 저장
			dto.setPhoto(photo);
		}
		// db에 insert
		boardService.insertBoard(dto);

		return "redirect:list?currentPage=" + currentPage; // 매핑주소로..
	}
	
	
	
	@PostMapping("/board/update") // 이미지 들어있으면 무조건 postMapping
	public String update(BoardDto dto, int currentPage, List<MultipartFile> upload,
			HttpServletRequest request)
	// currentpage가 반드시 넘어오므로 RequestParam안해도됨
	{

		// 업로드 경로
		String path = request.getSession().getServletContext().getRealPath("/resources/upload");
		// 경로 확인
		System.out.println(path);

		// 업로드를 안했을 경우 0번지의 파일명이 null이 아닌 ""(빈문자열)이 된다
		// 업로드를 안해도 upload size가 1이 된다
		System.out.println(upload.size());

		if (upload.get(0).getOriginalFilename().equals("")) { // 빈문자열이면 업로드를 안했을때

			dto.setPhoto(null);	//기존 사진은 수정안한다
		} else {
			String photo = "";

			// 파일명이 동일해지는것 방지하기 (mutliple 인 경우)
			int idx = 1;

			for (MultipartFile multi : upload) {
				// 파일명을 현재 날짜로 변경하고 컴마(,) 로 연결
				String newName = idx++ + "_" + ChangeName.getChangeFileName(multi.getOriginalFilename());
				photo += newName + ",";

				// 업로드
				try {
					multi.transferTo(new File(path + "/" + newName));
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 마지막 컴마 제거
			photo = photo.substring(0, photo.length() - 1);

			// dto에 저장
			dto.setPhoto(photo);
		}
		// db에 update
		boardService.updateBoard(dto);

		return "redirect:detail?currentPage="+currentPage+"&num="+dto.getNum();
	}
	
	@GetMapping("/board/detail") // 링크통해서 가는건 다 get .. 파일업로드가 포함되면 post
	public ModelAndView detail(int num, int currentPage) {
		ModelAndView mview = new ModelAndView();

		// 조회수 증가
		boardService.updateReadCount(num);

		// num에 해당하는 dto 얻기
		BoardDto dto = boardService.getData(num);

		// 글쓴 사람의 사진을 가져오기 memphoto
		// 이때 글쓴 사람이 탈퇴했을 경우 Null Pointer error 널 포인트 에러 발생한다 (try /cath)

		String memphoto = "";
		try {
			memphoto = memberService.getDataById(dto.getId()).getPhoto();
		} catch (NullPointerException e) {
			// TODO: handle exception
			memphoto = "no";
			dto.setName("탈퇴한 회원");
		}

		mview.addObject("dto", dto);
		mview.addObject("memphoto", memphoto);
		mview.addObject("currentPage", currentPage);

		mview.setViewName("/bit/board/boarddetail");

		return mview;
	}

		// 좋아요 증가
		@GetMapping("/board/likes")
		@ResponseBody
		public Map<String, Integer> likes(int num) {
			
			boardService.likesUpdate(num);	//조회수 증가
			int likes=boardService.getData(num).getLikes();
			Map<String, Integer> map=new HashMap<String, Integer>();
			
			map.put("likes", likes);
			
			return map;
			
		}
		
		@GetMapping("/board/delete")
		public String delete(int num, int currentPage)
		{
			boardService.deleteBoard(num);
			
			//삭제 후 보던 페이지로 이동
			return "redirect:list?currentPage="+currentPage;
			
		}
		
		@GetMapping("/board/updateform")
		public String updateform(Model model,int num,int currentPage)
		{
			//num에 해당하는 dto얻기
			BoardDto dto=boardService.getData(num);
			
			//model에 저장
			model.addAttribute("dto",dto);
			model.addAttribute("currentPage",currentPage);
			
			return "/bit/board/updateform";
		}
}
