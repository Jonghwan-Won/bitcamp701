package test.day0711;

public class Ex1DataType {

	//멤버 변수 선언하는 위치 - 자동초기화
	int a;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 지역 변수 - 자동 초기화 안됨
		
		int b = 0;
				
		// 멤버 변수 출력하는 방법
		Ex1DataType ex1=new Ex1DataType();
		System.out.println(ex1.a);		// 0 : 멤버변수로 선언한 a는 자동초기화되며 int 이므로 0
		
		System.out.println(b);			// 0 : 지역변수로 선언한 b는 0으로 초기화했으므로 0				

		byte c = 120; //byte 는 127까지 가능
		System.out.println(c);
		
		byte d = (byte)129; //cast 연산자 (강제 형변환 연산자)
		System.out.println(d);  //값이 넘칠 경우 음수로 읽는다 (2의 보수로 읽음)
		
		short su1=32700;
		short su2=20000;
		int sum=su1+su2;
		//short 끼리 계산하면 int로 자동 인식하므로 강제형변환 필요없음 (int)(su1+su2)
		System.out.println(sum);
		
		int n1=7;
		int n2=4;
		int div1=n1/n2; //int 끼리의 연산은 결과도 int 임
		System.out.println(div1);		// 1 : 7/4 의 몫은 1
		
		double div2 = n1/n2;			// n1/n2 : 1이지만 double 실수형이므로 1.0 결과가 나옴
		System.out.println(div2);
		
//		double div3 = (double)n1/n2; // 1.75 -> 둘 중 하나만 강제 형변환하면 소수점 아래 계산됨
//		double div3 = n1/(double)n2; // 1.75 -> 둘 중 하나만 강제 형변환하면 소수점 아래 계산됨
		double div3 = (double)(n1/n2); // 1.0 -> 이미 1로 계산된 상태에서 형변환하므로 1.0 나옴
		System.out.println(div3);
		
		
		
		
	}

}
