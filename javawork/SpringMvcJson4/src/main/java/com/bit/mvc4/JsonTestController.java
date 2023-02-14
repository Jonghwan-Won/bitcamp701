package com.bit.mvc4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody	/* json처리 후 브라우저로 출력(일반 Controller일 경우) */
	public Map<String, String> list()
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "이승기");
		map.put("hp", "010-1111-2222");
		map.put("addr", "강남구 역삼동");
		
		return map;
	}
	
	@GetMapping("/list2")
	@ResponseBody
	public List<PhotoDto> list2()
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		list.add(new PhotoDto("개운해", "개운해.jpg"));
		list.add(new PhotoDto("나무늘보", "나무늘보.gif"));
		list.add(new PhotoDto("냐", "냐.gif"));
		list.add(new PhotoDto("파이리", "파이리.gif"));
		
		return list;
	}
	
}
