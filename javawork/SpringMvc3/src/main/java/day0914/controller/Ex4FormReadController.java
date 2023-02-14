package day0914.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex4FormReadController {

	@GetMapping("/study/form4")
	public String form4()
	{
		
		return "forms/form4";
	}
	
	@PostMapping("/study/read4")
	public ModelAndView read4(HttpServletRequest request,
			String desc,
			ArrayList<MultipartFile> upload)	/*@RequestParam 생략*/
	{
		ModelAndView mview=new ModelAndView();
		
		//사진을 업로드할 톰캣 내 프로젝트의 경로 구하기
		String uploadFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(uploadFolder);
		
		//업로드한 파일의 파일명은 , 로 연결해서 저장
		String photo="";
		
		for(MultipartFile file:upload)
		{
			//파일명을 photo에 저장
			photo+=file.getOriginalFilename()+",";
			
			//업로드
			try {
				file.transferTo(new File(uploadFolder+"/"+file.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("파일 업로드 오류 발생 :"+e.getMessage());
			}
			
		}
		
		//마지막 컴마 제거
		photo=photo.substring(0,photo.length()-1);
		
		//model에 저장
		mview.addObject("desc",desc);
		mview.addObject("photo",photo);
		mview.addObject("count",upload.size());
		
		mview.setViewName("result/result4");
		return mview;
	}
}
