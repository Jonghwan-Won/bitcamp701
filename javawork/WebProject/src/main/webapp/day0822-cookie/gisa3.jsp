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
			[디지털데일리 권하영 기자] 미디어로그(대표 남승한) U+알뜰모바일은
			삼성전자 갤럭시Z플립4·폴드4 출시를 기념한 ‘자급제+알뜰폰’ 꿀조합
			5대 혜택 이벤트를 이달 말까지 실시한다고 22일 밝혔다.

			우선, 자급제 갤럭시폰으로 보험 가입시 선착순 500명 대상 종합형 또는
			파손형 보험 6개월을 지원한다. 납부한 보험료는 U+알뜰모바일(유알모)
			포인트로 리워드해준다. 유알모 포인트는 요금 납부 및 유알모 마켓에서 현금처럼 사용할 수 있다.
    		</pre>
    	<% } else {	%>
    		
    		<script>
    			alert("먼저 암호를 입력해주세요");
    			history.back();
			</script>
			<% } %>
    
    
    
    
    
    
    
    