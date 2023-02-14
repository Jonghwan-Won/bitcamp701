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
			[디지털데일리 강소현 기자] "영상이 기획·제작·유통된 뒤 수익화되기 까지의 과정은 굉장히 깁니다.
			콘텐츠 기획이나 제작 단계에서 엎어졌을 때, 혹은 유통이 되고 수익이 나지 않는다면 세액공제를
			받을 수 없으며 제작사가 모든 리스크를 감수해야 합니다." 

			김용희 동국대 교수는 22일 서울 여의도 국회의원 회관에서 진행된
			 ‘영상콘텐츠 세제지원 제도 개선 방향 세미나’에서 “해외에선 제작이라는 행위 자체가
			  이뤄졌을 때 제작비에 대해 환급해 주는 등 제작사의 리스크를 줄여주기 위한 다양한
			   제도가 갖춰진 점을 고려할 필요가 있겠다”며 이같이 밝혔다.
    		</pre>
    	<% } else {	%>
    		
    		<script>
    			alert("먼저 암호를 입력해주세요");
    			history.back();
			</script>
			<% } %>
    
    
    
    
    
    
    
    