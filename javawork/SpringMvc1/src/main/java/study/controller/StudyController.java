package study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudyController {

	@GetMapping({"/bit/study1","/bit/study2"})
	public String study(Model model)
	{
		//request에 저장
		model.addAttribute("name","예쁜이");
		model.addAttribute("age","20세");
		model.addAttribute("hp","010-1234-1234");
		model.addAttribute("photo","아이스아메리카노.JPG");
		
		//포워드 대상 : study.jsp
		return "study";
		
	}

}
