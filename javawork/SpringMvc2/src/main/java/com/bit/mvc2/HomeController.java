package com.bit.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@GetMapping("/")
	public String form1()
	{
		return "day1/form1";
	}
	
	@GetMapping("/process1")
//	public String process(Model model, @RequestParam("name") String name,
//			@RequestParam("addr") String addr)
	public String process(Model model, String name, String addr)
	//변수가 같으면 @RequestParam("addr")은 생략 가능하지만, form태그의 name과 addr이 아닐경우 에러발생
	//예를들어 form1 에서 addr을 addr1 로 바꾸면 null값 혹은 에러발생
	{
		String msg=name+"님은 "+addr+"에 살고있어요!!";
		model.addAttribute("msg",msg);
		return "day1/result1";
	}
}
