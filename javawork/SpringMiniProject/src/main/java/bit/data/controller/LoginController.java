package bit.data.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.data.dto.MemberDto;
import bit.data.service.MemberServiceInter;

@Controller
@RequestMapping("/member")
public class LoginController {

	@Autowired
	MemberServiceInter memService;
	
	@GetMapping("/login")
	@ResponseBody
	public Map<String, String> loginprocess(String id,String pass,HttpSession session)
	{
		Map<String, String> map=new HashMap<String, String>();
		int result=memService.getIdPassCheck(id, pass);
		if(result==1)	//id와 pass가 모두 맞는경우 (로그인상태)
		{
			//유지 시간 설정
			session.setMaxInactiveInterval(60*60*4);	//1분-> 1시간 -> 4시간
			
			//로그인한 아이디에 대한 정보를 얻어서 세션에 저장
			MemberDto mdto=memService.getDataById(id);
			session.setAttribute("loginok", "yes");
			session.setAttribute("loginid", id);
			session.setAttribute("loginname", mdto.getName());
			session.setAttribute("loginphoto", mdto.getPhoto());
		}
		map.put("result", result==1?"success":"fail");
		return map;
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public void logout(HttpSession session)
	{
		//로그아웃 시 제거되어야 할 세션
		session.removeAttribute("loginOk");	//이걸로 비교할거라서 얘만 지우면되지만, id까지 지우기로함
		session.removeAttribute("loginId");
	}
}
