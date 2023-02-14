package com.bit.mvc1;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller	//자동으로 xml 설정파일에 bean 등록
public class HomeController {

	//메서드 만들기
	//리턴 구조는 5.0버전 이전까지는 무조건 request mapping
	//@RequestMapping(value="/",method = RequestMethod.GET)	//5.0이전과 이후 모두 사용 가능
	//requestMapping 은 post 와 get 모두 사용가능
	@RequestMapping("/")	//method가 GET인 경우 생략 가능
	public String home(Model model)	//model 선언해주고 request에 저장하는 코드
	//request에 저장하는 클래스가 model
	{
		//request에 저장
		model.addAttribute("today",new Date());
		model.addAttribute("message","오늘은 스프링 MVC시작하는날!!!");
		
		//어디로 포워드할지는 설정 파일에 기록되어있음
		return "hello";
		//포워드(url주소 안바뀜, request, response 그대로 전달)
		// servlet-context.xml 파일 -> /WEB-INF/views/hello.jsp
		
	}
	
	//@GetMapping 5.0에서 추가된 기능
	//Controller는 무조건 /슬래시로 시작 (../ 가 아닌 /)
	@GetMapping("/board/list")	//이 경우 board/list board/list.do, board/list.bit 모두 호출됨
//	@GetMapping("/board/list.do")	//이 경우 board/list.do 만 호출됨
	//GET방식 ... 5.0에서 추가된 기능 // 가상의 mapping 주소

	public ModelAndView go1()	//메서드명은 의미없음
	{
		ModelAndView mview=new ModelAndView();
		//request에 저장
		mview.addObject("name","한가인");
		mview.addObject("addr","서울시 강남구");
		
		// 포워드할 파일명 지정
		// /WEB-INF/views/result.jsp 로 포워드
		mview.setViewName("result");
		
		
		return mview;
	}
}
