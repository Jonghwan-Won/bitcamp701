package test.day0725;
//interface는 상수(final)와 추상(abstract)메소드로만 구성되어있다
//실체가 없는 선언문만 있기때문에 음식점의 메뉴판에 비유를 한다
interface InterA
{
	int SPEED=200;	//상수이다,,final 생략
	public void speedUp();	//모든 메서드는 추상 메서드이지만 abstract는 생략
	public void speedDown();
	
}

//interface를 구현할때는 implements
class My implements InterA
{
	// 우클릭 > source > Override/Implements Methods > 자동으로 체크되어있음
	int mySpeed=SPEED;
	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		mySpeed+=10;
		System.out.println("현재 속도 : "+mySpeed);
		
		
	}

	@Override
	public void speedDown() {
		// TODO Auto-generated method stub
		mySpeed-=10;
		System.out.println("현재 속도 : "+mySpeed);
	}
	
}

public class Ex8Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA a1=new My();
		a1.speedDown();
		a1.speedUp();
		
		My a2=new My();
		a2.speedUp();
		a2.speedDown();
	}

}
