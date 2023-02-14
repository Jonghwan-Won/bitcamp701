package test.day0726;

interface Hello
{
	public void draw();
	public void add();
}

public class Ex3Anony {

	//member 내부 클래스(정식으로 상속 받은)
	class SubHello1 implements Hello
	{

		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("draw");
			
		}

		@Override
		public void add() {
			// TODO Auto-generated method stub
			System.out.println("add");
		}
		
	}
	
	//익명 내부 클래스
	Hello hello2=new Hello() {
		
		@Override
		public void draw() {
			// TODO Auto-generated method stub
			System.out.println("draw2");
		}
		
		@Override
		public void add() {
			// TODO Auto-generated method stub
			System.out.println("add2");
		}
	};	//하나의 문장으로 보기때문에 ;로 끝내야함
	
	
	
	public void process()
	{
		//내부 클래스 선언
		SubHello1 s1=new SubHello1();	//정식클래스이기떄문에 new로 생성해주고 호출
		s1.draw();
		
		//익명 내부 클래스는 그냥 변수명으로 메서드 호출하면됨
		hello2.draw();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3Anony ex=new Ex3Anony();
//		Ex3Anony.SubHello1 in1=ex.new SubHello1();
//		in1.draw();
		
		ex.process();
		
	}

}
