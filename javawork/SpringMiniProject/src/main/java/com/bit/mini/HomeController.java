package com.bit.mini;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home()
	{
	
		return "/bit/layout/main";	//WEB-INF/layout/main.jsp 가 초기 메인페이지가됨
	}
	
	
	
	//memberlist 부분 잘라내서 MemberController에 옮겼음
	
	@GetMapping("/help/map")
	public String map()
	{
		
		return "/bit/help/googlemap";	//bit2로 설정
	}
	
	
}
