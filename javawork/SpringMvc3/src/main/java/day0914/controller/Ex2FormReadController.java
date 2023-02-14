package day0914.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex2FormReadController {

	@GetMapping("/study/form2")
	public String form2()
	{
		
		return "forms/form2";
	}
	
	@PostMapping("/study/read2")
	public ModelAndView read2(@RequestParam Map<String, String> map)
	//Map<key,value> : Map으로 읽을 경우 폼태그의 name이 key, 입력값이 value 로 저장됨
	//@RequestParam 생략 가능?
	{
		ModelAndView mview=new ModelAndView();
		//ModelAndeView가 다 포함하고있으므로 model 따로 안해줘도 됨
		mview.addObject("name", map.get("name"));
		mview.addObject("hp", map.get("hp"));
		mview.addObject("java", map.get("java"));
		mview.addObject("spring", map.get("spring"));
		mview.addObject("fontcolor", map.get("fontcolor"));
		
		mview.setViewName("result/result2");
		return mview;
	}
}
