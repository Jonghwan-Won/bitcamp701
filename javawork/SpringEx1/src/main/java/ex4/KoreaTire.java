package ex4;

import org.springframework.stereotype.Component;

//bean으로 자동등록
@Component
public class KoreaTire implements Tire {

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "한국금호타이어";
	}

}
