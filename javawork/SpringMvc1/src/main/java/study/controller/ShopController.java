package study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

	@GetMapping("/bit/shop")
	public String myshop(Model model)
	{
		//list에 담기
		List<ShopDto> list=new ArrayList<>();
		list.add(new ShopDto("블라우스", "orange", 29000));
		list.add(new ShopDto("청바지", "skyblue", 30000));
		list.add(new ShopDto("원피스", "yellow", 49000));
		list.add(new ShopDto("자켓", "gray", 52000));
		
		model.addAttribute("list",list);
		
		return "shop";
	}
	
}
