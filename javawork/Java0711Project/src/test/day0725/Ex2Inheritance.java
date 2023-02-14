package test.day0725;

class Super2
{
	private String carName;
	private String carColor;
	
	Super2()	//디폴트 생성자
	{
		System.out.println("부모디폴트 생성자 호출");
		carName="벤츠";
		carColor="은색";
	}
	
	Super2(String carName, String carColor)	// 파라미터 받는거
	{
		this.carName=carName;
		this.carColor=carColor;
		
	}
	
	public void writeCar()
	{
		System.out.println("차이름:"+carName);	// this. 생략
		System.out.println("차색상:"+carColor);
	}
	
}

//상속받은 Car 클래스
class Car extends Super2
{
	private int carPrice;
	
	Car()	//디폴트 생성자
	{
		super(); // 생략되어있음, super생략시 무조건 디폴트 호출
		System.out.println("자식 클래스 Car 디폴트 생성자 호출");
		carPrice=2000;
		
	}
	
	Car(int carPrice)
	{
//		super();	//super 생략시 무조건 디폴트 super 호출 
		this.carPrice=carPrice;
	}
	
	Car(String carName, String carColor, int carPrice)
	{
		super(carName,carColor); //부모생성자중에 인자가 2개인 생성자가 호출, 반드시 첫줄에 있어야함
		this.carPrice=carPrice;
	}
	
	@Override
	public void writeCar() {
		// TODO Auto-generated method stub
		super.writeCar();
		System.out.println("자동차가격:"+carPrice);
	}
}

public class Ex2Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** 1번차구매 **");
		Car car1=new Car();
		car1.writeCar();	//car 클래스가 가진 writeCar 호출
		System.out.println("** 2번차구매 **");
		Car car2=new Car(3400);
		car2.writeCar();
		System.out.println("** 3번차구매 **");
		Car car3=new Car("소나타","검정색",1900);
		car3.writeCar();
		
		System.out.println(car3);	//car3같은 인스턴스, 레퍼런스 변수는 호출하면 주소(경로)같은게 나옴
	}

}
