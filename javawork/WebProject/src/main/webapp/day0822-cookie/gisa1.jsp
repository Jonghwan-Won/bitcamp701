<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	boolean blogin=false;
    
  		//브라우저에 저장된 모든 쿠키값들을 얻는다
    	Cookie []cookies=request.getCookies();
  		
    	if(cookies!=null){
    		for(int i=0;i<cookies.length;i++){
    			//cookieok 가 있는지
    			String cookieok=cookies[i].getName();    			
    			if(cookieok.equals("cookieok"))	//cookieok라는 이름을 가진 쿠키가 있을 경우
    			{
    				blogin=true;
    			}
    		}
    	}
    	
    	if(blogin){
    		//기사 열람
    		%>
    		<pre>
    		
			[디지털데일리 왕진화 기자] 라인게임즈의 올해 최대 기대작으로 꼽히는 ‘대항해시대 오리진’과 넥슨게임즈
			첫 출범 이후 선보이는 공식 타이틀 ‘히트2(HIT2)’가 각각 오는 23일, 25일 국내 게임 시장에서 본격 항해를 시작한다.

			국내 모바일 양대마켓에서 완고하게 자리를 지키고 있는 ‘리니지 시리즈’를 비롯해, 
			카카오게임즈 히트작 ‘오딘:발할라라이징’과 ‘우마무스메 프리티 더비’, 장기 흥행 궤도에
			 돌입한 넥슨 ‘던전앤파이터 모바일’이 구축한 구도를 이들 신작이 깰 수 있을지 이목이 집중된다.
    		
    		</pre>
    	<% } else {	%>
    		
    		<script>
    			alert("먼저 암호를 입력해주세요");
    			history.back();
			</script>
		<% } %>
    
    
    
    
    
    
    
    