package bit.data.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bit.data.dto.MemberDto;
import bit.data.service.MemberServiceInter;
import util.ChangeName;

@Controller
@RequestMapping("/member") 
	//앞의 공통적으로 들어가는 매핑을 설정하는 부분
	//membercontroller의 경우는 getmapping의 경로가 공통적으로 /member/...이므로 
public class MemberController {

	@Autowired
	MemberServiceInter memService;
	
	//잘라내기 붙여넣기 (홈컨트롤러)
	//getallmembers
	@GetMapping("/list")
	public String mlist(Model model)
	{
		//총 멤버 인원수를 db에서 얻는다
		int totalCount=memService.getTotalCount();
		
		//전체 멤버 데이터를 가져온다
		List<MemberDto> list=memService.getAllMembers();
		
		//model 에 저장한다 -> 위에 mlist() 요기에 Model model 써주기
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "/bit/member/memberlist";
	}
	
	//새로 추가
	@GetMapping("/form")
	public String mform()
	{
		
		return "/bit/member/memberform";
	}
	
	//requestMapping 은 get이냐 post냐 가리지않음
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, MemberDto dto, MultipartFile myphoto)
	{
		//톰캣 내 upload 폴더 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		//저장할 파일명 구하기
		String fileName=ChangeName.getChangeFileName(myphoto.getOriginalFilename());
		
		//dto 의 photo에 저장
		dto.setPhoto(fileName);
		
		//upload
		try {
			myphoto.transferTo(new File(path+"/"+fileName));
			
			//db insert
			memService.insertMember(dto);
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return "redirect:list";		//	/member/list 매핑주소 호출 - 컨트롤러 메서드 호출
	}
	
	//중복 아이디 체크하는 메서드 -> json 으로 반환
	@GetMapping("/idcheck")	//원래는 /member/idcheck
	@ResponseBody	//json 반환 //일반 컨트롤러이기때문
	public Map<String, Integer> getSearchId(String id)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		int count=memService.getSearchId(id);	//id가 있을 경우 1, 없을 경우 0반환
		map.put("count", count);	//"count" 라는 값으로 보내겠다 (0또는 1)
		
		return map;
	}
	
	//멤버리스트 내 사진수정
	@PostMapping("/updatephoto")
	@ResponseBody
	public void photoUpload(HttpServletRequest request, HttpSession session,
			int num, MultipartFile photo)
	{
		//톰캣 내 upload 폴더 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		//저장할 파일명 구하기 (현재 날짜로 파일명 변경)
		String fileName=ChangeName.getChangeFileName(photo.getOriginalFilename());
		
		//upload
		try {
			photo.transferTo(new File(path+"/"+fileName));
			
			//db insert
			memService.updatePhoto(num, fileName);	//db에서 사진 수정
			session.setAttribute("loginphoto", fileName);	//세션의 사진 수정
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	//삭제 -> 본인 삭제의 경우 탈퇴와 같으므로 수정함 num 만 받는거에서 세션도 지워야해서 session 도 사용
	@GetMapping("/delete")
	@ResponseBody //이거를 쓰면 포워드를 요구하는일을 하지않아도 된다
	public void delete(int num, HttpSession session)
	{
		memService.deleteMember(num);
		//로그인한 본인 db삭제 후 모든 세션 지우기
		session.removeAttribute("loginok");
		session.removeAttribute("loginid");
		session.removeAttribute("loginname");
		session.removeAttribute("loginphoto");
	}

	//수정폼에 출력할 데이터를 반환
	@GetMapping("/updateform")	//jquery로도 form 읽는 방법 활용
	@ResponseBody
	public MemberDto getData(int num)
	{
		return memService.getDataByNum(num);
	}
	
	//수정 : 데이터가 많으니까 post로
	@PostMapping("/update")
	@ResponseBody
	public void update (MemberDto dto, HttpSession session)
	{
		memService.updateMember(dto);
		
		//로그인 한 본인 db를 수정하고, 세션의 name값이 헤더에 표시되므로(oOO님) 세션도 수정
		session.setAttribute("loginname", dto.getName());
	}
}
