package test.day1;

public class Ex1DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java Test!!!");
//		System.out.println(args[0]);
//		System.out.println(args[1]);
		
		byte a=127;
		byte b=(byte) 200; //ctrl + 1 강제로 넣기 (cast 연산자, 강제 형변환 연산자)
		System.out.println(a);
		System.out.println(b);
		
		short c=200;
		System.out.println(c); // 200정도를 주려면 최소 short.. 웬만하면 int 로 충분함
		
		int d=34000;
		System.out.println(d); // short 로는 안됨
		
//		float f1=1.2; -> f를 붙이면 4바이트로 잡히고 안붙이면 8바이트로 잡혀서 double로 해야함 또는 강제 형변환
		float f1=1.2f; // 소수점을 찍으면 8바이트로 잡힘 double 또는 강제형번환 또는 f 붙이기
		double f2=1.3;
		System.out.println(f1);
		System.out.println(f2);
		
		float f3=12.3456789f;
		double f4=12.3456789;
		System.out.println(f3); //소수점 포함 8자리까지만 정확하게 나오고 이후는 반올림
		System.out.println(f4); // double은 정밀도가 소수점 포함 15자리까지

		boolean b1=true;
		System.out.println(b1);
		System.out.println(!b1); // ! : not (반대)
		
		
	}

}



// ctrl + space : 자동완성 (ex. syso 하고 커맨드)

// 주석1 - 한 줄 주석 (비 실행문) : ctrl + /(슬래시)

/*
 *  주석2 - 여러 줄 주석 : ctrl + shift + /(슬래시)
 */
