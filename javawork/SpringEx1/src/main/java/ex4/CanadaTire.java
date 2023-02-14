package ex4;

import org.springframework.stereotype.Component;

//@component : 자동으로 xml파일에 bean을 등록해준다
//@Component : 클래스명이 id가 되는데 단, 첫글자는 소문자로 된다 즉 canadaTire
//@Component("ctire") : ctire가 id가 된다
@Component
public class CanadaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "캐나다타이어";
	}

}
