package test.day0713;

public class Ex6String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="Apple";
		String s2="Have a Nice Day!!";
		String s3="appLe";
		
		System.out.println(s1.equals(s3)); //대소문자가 다르므로 false
		System.out.println(s1.equalsIgnoreCase(s3)); //대소문자 상관없이 철자만 비교 true
		
		//compareTo  : 나중에 배열할때 다시
		System.out.println("apple".compareTo("apple")); // 같을 경우 0
		System.out.println("banana".compareTo("apple")); // 1
		System.out.println("apple".compareTo("banana")); // -1
		System.out.println("computer".compareTo("compare")); // u 와 a 비교 20
		System.out.println("강호동".compareTo("강호순")); // 음수값
		
		System.out.println("s2의 길이: "+s2.length());
		String s4="  hello  ";
		System.out.println("s4의 길이: "+s4.length());
		System.out.println("양쪽 공백 제거후 길이 구하기: "+s4.trim().length());
		
		// N의 index 구하기 (s2에서 N의 위치 구하기)
		System.out.println("s2.indexOf('N'):"+s2.indexOf('N'));
		
		// *의 인덱스 구하기 : 없을경우 얼마가 나오는지 확인
		System.out.println(s2.indexOf('*')); // 없을 경우 -1
		
		String s5="hello world";
		if(s5.indexOf(32)==-1)   // 없을 경우 -1 이고, 	' ' or 32 <= 32는 아스키코드 공백
			System.out.println("s5에는 공백이 없어요");
		else
			System.out.println("s5에는 공백이 포함되어 있어요");

		
		System.out.println(s2.toLowerCase()); //무조건 소문자로 변환해서 출력
		System.out.println(s2.toUpperCase()); //무조건 대문자로 변환해서 출력

		// 특정 단어로 시작하면 true
		System.out.println(s2.startsWith("Have")); //true, Have로 시작
		System.out.println(s2.endsWith("*")); //false, * 로 끝나야만 true인데 ! 로 끝남
		System.out.println(s2.contains("Nice")); // Nice를 포함하고있으면 true
		System.out.println(s2.contains("Good")); // Good을 포함하고있으면 true
		
		// concat : 문자열 추가		+ 하면되기때문에 굳이 잘 안씀
		System.out.println(s1.concat("Happy"));
//		System.out.println(s1+"Happy");
		
		String color="red,green,blue,magenta";
		System.out.println(color);
		// 문자열에서 ,(컴마)로 분리하기 - 결과는 배열형태		java랑 javaScript에서 자주 쓴다고함
		String []arrcolor=color.split(",");
		System.out.println("총 배열갯수 :"+arrcolor.length);
		
		
	}

}
