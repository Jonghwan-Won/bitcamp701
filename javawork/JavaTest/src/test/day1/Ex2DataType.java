package test.day1;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a='A'; // 2byte이지만 영문이 2글자가 들어가지는 않음
		char b='가'; // 다른 언어와 다르게 한글 2byte가 안깨지고 잘 나옴
		System.out.println(a);
		System.out.println(b);
		
		char c=98;
		System.out.println(c); //아스키코드의 정수표 13=enter, 32=space bar
		
		int d=0x44; // 0x : 16진수, 44 : 4*16 + 4 = 68 (16의 1승, 16의 0승을 각각 곱함)
		System.out.println(d); // 10진수로 출력
		System.out.println((char)d); //D
		
		int e=056; //0으로 시작 : 8진수 5*8+6
		System.out.println(e);
		System.out.println((char)e);

		//Hello 출력 - 아스키코드 활용 (127까지는 세계 공통)
		System.out.print((char)72);
		System.out.print((char)101);
		System.out.print((char)108);
		System.out.print((char)108);
		System.out.println((char)111);
		
		int f=0x55; //5*16+5=85
		System.out.println((char)f);
		System.out.println(f);
		
		int g=0xa3;//a=10 , 10*16+3=163
		System.out.println(g);
		
		
	}

}
