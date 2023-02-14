package day0914.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex3FormReadController {
	@GetMapping("/study/form3")
	public String form3()
	{
		
		return "forms/form3";
	}
	
	@PostMapping("/study/read3")
	public ModelAndView read3(HttpServletRequest request,
			@RequestParam String desc,
			@RequestParam MultipartFile upload)
	{
		ModelAndView mview=new ModelAndView();
		//사진을 업로드할 톰캣 내 프로젝트의 경로 구하기(지정하기?)
		String uploadFolder=request.getSession().getServletContext().getRealPath("/resources/upload");
		//getRealPath 만 필요한데 위 경로를 타고가야지만 사용할 수 있음
		
		//System.out.println(uploadFolder);	//경로 잘 됐는지 중간확인
		
		//업로드할 파일명
		String fileName=upload.getOriginalFilename();
		//지금은 OriginalFilename으로 하지만, 추후에는 중복 방지를 위해 초단위 까지 저장되도록 하는게 좋음
		
		//위의 경로에 사진을 업로드하기
		try {
			upload.transferTo(new File(uploadFolder+"/"+fileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일 업로드 오류 발생 :"+e.getMessage());
		}
		
		//model에 데이터 저장
		mview.addObject("desc",desc);
		mview.addObject("fileName",fileName);
		
		mview.setViewName("result/result3");
		return mview;
	}
}
