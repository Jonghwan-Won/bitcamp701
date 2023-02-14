package com.bit.mvc3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home()
	{
		
		return "views/home";
		//servlet-context 에서 views 까지의 경로를 제거했기때문에 써줘야됨
	}
	
}
