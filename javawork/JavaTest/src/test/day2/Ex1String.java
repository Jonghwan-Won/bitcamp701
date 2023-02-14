package test.day2;

public class Ex1String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1=new String("Happy Day!!");
		String s2="Have a Nice day!!";
		String s3="Apple";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("s1 length:"+s1.length()); //.을 누르면 메소드 목록이 나열됨
		System.out.println("s2 length:"+s2.length()); // 길이 구하기
		
		//substring(a,b) : a부터 (b-1)까지 추출
		System.out.println("Have 추출:"+s2.substring(0, 4));
		//s1에서 Day만 추출
		System.out.println("Day 추출:"+s1.substring(6, 9));

		//charAt, indexOf
		//s1에서 0번 인덱스에 들어있는 char문자
		System.out.println(s1.charAt(0));
		System.out.println(s2.charAt(7)); //7번 인덱스의 문자 (공백 포함임)

		//s1에서 첫번째 D의 인덱스 위치 알아보기
		System.out.println(s1.indexOf('D'));
		//s2에서 첫번째 a의 위치
		System.out.println(s2.indexOf('a'));
		//s2에서 마지막 a(97_아스키코드) 의 위치
		System.out.println(s2.lastIndexOf(97));

		//문자열 비교 (String s3 위에서 추가함) 
		System.out.println(s3.equals("apple")); //false : 완전히 같으면 True
		System.out.println(s3.equals("Apple")); //true : 대소문자까지 같아야 True
		//대소문자 상관없이 비교
		System.out.println(s3.equalsIgnoreCase("aPPlE"));

		//특정 문자열로 시작할경우 true
		System.out.println(s1.startsWith("Happy")); //true
		System.out.println(s1.startsWith("Nice")); //false
		//특정 문자열로 끝날경우 true
		System.out.println(s2.endsWith("!")); //true : !로 끝나는가
		System.out.println(s2.endsWith("*")); //false : *로 끝나는가
	}

}
