package test.day0711;

public class Ex4AsciiCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 65;	//10진수
		int b = 0x41; //16진수
		int c = 'A'; //char형
		
		System.out.println(a==b); // == 기본형 Data type 에서만 사용 가능 -> 같으면 Ture
		System.out.println(a==c); // == 기본형 Data type 에서만 사용 가능 -> 같으면 Ture
		// 문자열 Data type
		
		System.out.println(a+","+(char)a);
		
		// 출력문중에 printf 라고 있는데, 변환기호로 출력을 해주는 메서드(jdk5에서 추가된 기능)
		// 변환기호 : 정수(%d), 문자(%c), 실수(%f), 문자열(%s)
		
		System.out.printf("%c,%c,%c\n",a,b,c);
		System.out.printf("%c,%c,%c,%c\n",a+32,a+33,a+34,a+35); //abcd
		
		System.out.println(a+35);
		System.out.println((char)(a+35));
		
		double d = 13.45678;
		System.out.printf("%f,%3.2f,%10.1f%-10.2f*\n",d,d,d,d);
		// %f 출력, 총 3칸 + 소수점 아래 2자리,
		// 총 10칸(오른쪽 정렬) + 소수점 아래 1자리, 총 10칸(- 왼쪽 정렬) + 소수점아래 2자리, *
		
		
		char c1='a';
		char c2='a';
		
		
		System.out.println(c1);
		
		
		if(c1==c2)
			System.out.println("c1 과 c2는 같습니다 : "+c1);
		else
			System.out.println("다름");
		
	
	}

}
