package day1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HappyController {
	
	//여러 매핑주소로 하나의 jsp로 포워드하는 법
	@GetMapping({"/hello","/happy","/bit/show"})
	public String process(Model model)
	{
		List<String> list=new ArrayList<>();
		//new ArrayList<>(); -> <String>을 생략한건데 에러나면 프로젝트 프로포티 -> 자바 버전 1.6을 11로 (버전이낮아서그럼)
		list.add("red");
		list.add("orange");
		list.add("yellow");
		list.add("green");
		list.add("blue");
		list.add("navy");
		
		model.addAttribute("list",list);	//request에 저장
		
		return "result2";
	}
}
