package test.day3;

public class Ex12While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=10;
		System.out.println("while문");
		
		while(n>10) //조건이 안맞으므로 한번도 반복되지않음
		{
			System.out.println(n);
		}
		
		System.out.println("do~while문");
		//일단 한번 실행후 조건을 비교한다 (최소 한번은 실행)
		do {
			System.out.println(n);
		}while(n>10);
			
		
		
	}

}
