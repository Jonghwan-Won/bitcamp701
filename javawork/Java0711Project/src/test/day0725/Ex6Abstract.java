package test.day0725;

import java.util.Scanner;

class Parent
{
	public void process()
	{
		System.out.println("나는 super 부모클래스-일을 시킨다");
	}
}

//////////////////////////////////////

class Child1 extends Parent
{
	@Override	// process를 override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("첫째딸:나는 집안 전체 청소를 한다");
	}
	
}

//////////////////////////////////////

class Child2 extends Parent
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("둘째아들:집안의 고장난곳을 모두 고친다");
	}
}

//////////////////////////////////////

class Child3 extends Parent
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("셋째아들:집안의 모든 유리창을 닦는다");
	}
	
}




public class Ex6Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		Parent p=null;	//변수는 무조건 부모로
		while(true)
		{
			System.out.println("선택하세요");
			System.out.println("1.부모 2.첫째 3.둘째 4.셋째 5.종료");
			int num=sc.nextInt();
			switch(num)
			{
			case 1:
				p=new Parent(); break;
			case 2:
				p=new Child1(); break;
			case 3:
				p=new Child2(); break;
			case 4:
				p=new Child3(); break;
			default:
				System.out.println("종료합니다");
				System.exit(0);
			}
			//생성된 클래스가 가진 process가 호출이 된다
			//단 자식클래스인경우 반드시 오버라이드 메서드라야 한다
			
			p.process(); //누가 생성되었느냐에 따라 하는일이 달라진다(다형성이라고도 한다)
				
		}
		
	}

}
