package test.day0711;

public class Ex3DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// float(4 byte), double(8 byte)
		// 실수형은 정밀도가 중요
		// 초기화 시 . 소수점이 들어가면 무조건 double 로 인식
		
		float f1=(float)3.4; 	// 방법1 : 소수점이 들어가면 double로 인식하므로 (float)으로 형변환
		float f2=4.2f;	     	// 방법2 : 소수점이 들어가면 double로 인식하므로 뒤에 f를 붙여 형변환
		System.out.println(f1);
		System.out.println(f2);
		
		float f3=13.123456789f; // 소수점 포함 8자리까지 표기됨 (그 이후는 반올림처리)
		double f4=13.123456789; // 소수점 포함 15자리까지 표기됨
		System.out.println(f3);
		System.out.println(f4);
		
		// 문자 1글자 char. 문자열 String
		char ch1='A';
		char ch2='가'; // char가 2byte 이므로 한글도 안깨지고 나옴
		System.out.println(ch1);
		System.out.println(ch2);
		
		// String 에 문자열을 저장하는 방법
		String s1=new String("Apple"); // 방법 1
		String s2="Banana"; // 방법 2
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1+s2);
			
		
	}

}
