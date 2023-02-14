package day0914.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import day0914.dto.SawonDto;

@Controller
public class Ex1FormReadController {

	@GetMapping("/study/form1")
	public String form1()
	{
		
		return "forms/form1";
	}
	
	@PostMapping("/study/read1")
	//@ModelAttribute : 통째로 읽을때 사용 // dto의 멤버와 이름이 같은 폼태그는 자동으로 읽어온다
	//생략 가능, dto 자체가 model에 저장..(저장되는 이름은 sawonDto로 저장)
	//@ModelAttribute("sdto") SawonDto dto : model 에 sdto로 저장
	public ModelAndView read1(@ModelAttribute SawonDto dto)
	{
		ModelAndView mview=new ModelAndView();
		//ModelAndeView가 다 포함하고있으므로 model 따로 안해줘도 됨
		
		mview.setViewName("result/result1");
		return mview;
	}
}
