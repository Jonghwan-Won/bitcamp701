package test.day3;

import java.util.Scanner;

public class Ex2Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		//문자열이 아닌 문자열의 첫글자만 char 로 얻고자 할 경우
		System.out.println("알파벳 한글자 입력하기");
		char ch=sc.nextLine().charAt(0); //첫문자만 얻기
		switch(ch) {
		//소문자 a거나 대문자 A일경우 Apple 출력
		//일부러 소문자 a일때 break 안걸어줘서 대문자 A가 실행됨
		case 'a':
		case 'A':
			System.out.println("Apple!!");
			break;
		case 'b':
		case 'B':
			System.out.println("Banana!!");
			break;
		default:
			System.out.println("그 이외의 알파벳:"+ch);
				
		}
		
	}

}
