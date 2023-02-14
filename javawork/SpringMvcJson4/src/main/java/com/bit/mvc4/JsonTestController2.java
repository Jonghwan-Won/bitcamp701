package com.bit.mvc4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import file.util.ChangeName;

//json 전용 컨트롤러 - 일반 메서드는 안됨, 스프링5.0 에서 추가된 기능
@RestController
public class JsonTestController2 {

	@GetMapping("/list3")
	public Map<String, Object> list3(@RequestParam String name)
	{
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		list.add(new PhotoDto("개운해", "개운해.jpg"));
		list.add(new PhotoDto("나무늘보", "나무늘보.gif"));
		list.add(new PhotoDto("냐", "냐.gif"));
		list.add(new PhotoDto("파이리", "파이리.gif"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "없는 메뉴");
		map.put("photo", "아이스크림.JPG");
		
		for(PhotoDto dto:list)
		{
			if(name.equals(dto.getName())){
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
	
	//단일 파일 업로드 ex4
	@PostMapping("/oneupload")
	public Map<String, String> fileUpload(@RequestParam("upload") MultipartFile multi,
			HttpServletRequest request)
	{
		//업로드 될 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		//업로드 될 파일명 구하기 (현재 날짜로 파일명을 변경하는 ChangeName클래스의 메서드 불러오기)
		String fileName=ChangeName.getChangeFileName(multi.getOriginalFilename());
		
		//업로드
		try {
			multi.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//리턴타입부터 맞추기
		Map<String, String> map=new HashMap<String, String>();
		map.put("photoname", fileName); //변경된 파일명을 json으로 보내기
		
		return map;	//json으로 변경됨
	}
	
	//여러사진 업로드 - 반환타입은 List<Map> - ex5
	@PostMapping("/multiupload")
	public List<Map<String, String>> multiUpload(HttpServletRequest request,
			List<MultipartFile> upload)	//변수명은 반드시 upload여야 함 (ex5에서 form데이터를 upload로 받기때문)
	{
		//업로드 될 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(path);
		
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		
		//여러개 파일이므로 반복문으로 처리한다
		int idx=1;	//동시에 업로드하기때문에 파일명이 같아지는 경우가 있으므로 문제해결을 위해 idx 사용하기
		
		for(MultipartFile file:upload)
		{
			//각 파일의 이름 변경해서 업로드하기
			String photoname=ChangeName.getChangeFileName(file.getOriginalFilename());
			
			photoname=idx+"_"+photoname;
			idx++;
			
			//변경된 파일 이름으로 파일 객체 생성
			File f=new File(path+"/"+photoname);
			
			//변경된 파일 이름으로 업로드
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//파일 사이즈
//			String photosize=((long)(f.length()/1024.0)*10)/10.0+"Kb";	//제대로 안나옴 (소수점 뒤에 0으로만나옴)
			String photosize=((long)((f.length()/1024.0)*10))/10.0+"Kb";
			//long타입이므로 소수점 이하를 자르기위한 작업
			
			//업로드 후 파일명과 파일사이즈를 구해서 Map에 넣은 후 List에 추가
			Map<String, String> map=new HashMap<String, String>();
			map.put("photoname", photoname);
			map.put("photosize", photosize);
			
			list.add(map);
		}
		
		return list;
		
	}
	
}
