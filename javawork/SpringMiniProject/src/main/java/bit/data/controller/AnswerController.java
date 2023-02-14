package bit.data.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.data.dto.BoardAnswerDto;
import bit.data.service.BoardAnswerServiceInter;
import util.ChangeName;

@RestController
@RequestMapping("/answer")	//기본 매핑 = /answer
public class AnswerController {

	//서비스
	@Autowired
	BoardAnswerServiceInter answerService;
	
	//마지막 사진이 DB에 저장되도록 (멤버변수)
	String uploadPhoto;
	
	
//댓글에서 사진 업로드할때 호출
//@ResponseBody //responseController라서 필요없음
	@PostMapping("/updatephoto") // -> /answer/updatephoto
	public Map<String, String> photoUpload(HttpServletRequest request, MultipartFile photo)	
	//바뀐사진으로 반환할거라서 void아님
	{
		//톰캣 내 upload 폴더 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		//저장할 파일명 구하기 (현재 날짜로 파일명 변경) -> 멤버변수 uploadPhoto에 저장
		uploadPhoto=ChangeName.getChangeFileName(photo.getOriginalFilename());
		
		//upload
		try {
			photo.transferTo(new File(path+"/"+uploadPhoto));
			
			/* //db처리 안할거라서 필요없음
			 * //db insert memService.updatePhoto(num, fileName); //db에서 사진 수정
			 * session.setAttribute("loginphoto", fileName); //세션의 사진 수정
			 */
			
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("aphoto", uploadPhoto);	//aphoto 변수로 uploadphoto를 보냄
		
		return map;

	}
		
	@PostMapping("/insert")	// /answer/list
	public void insert(BoardAnswerDto dto)
	{
		//사진만 따로 저장 후 DB insert
		if(uploadPhoto==null)	//사진 선택 안했을경우
			dto.setPhoto("no");
		else
			dto.setPhoto(uploadPhoto);
		
		answerService.insertAnswer(dto);
		
		uploadPhoto=null;	//그 다음 댓글을 위해서 사진이름은 null로 초기화
	}
	
	@GetMapping("/list")
	public List<BoardAnswerDto> list(int num)
	{
		
		return answerService.getAllAnswerList(num);
	}
	
	
	
	@GetMapping("/delete")
	public void delete(int idx, HttpServletRequest request)
	{
		//업로드 될 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		//데이터 삭제 전에 사진파일 지우기
		//사진명 얻기
		String photo=answerService.getAnswer(idx).getPhoto();
		
		//file 객체 생성
		File file=new File(path+"/"+photo);
		if(file.exists()) {
			System.out.println("파일이 존재하므로 삭제합니다");
			
			file.delete();	//해당 게시글에 첨부된 파일 삭제
			
		}
		
		answerService.deleteAnswer(idx);	//게시글 삭제
	}
	
}
