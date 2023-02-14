package test.day0713;

import java.util.Scanner;

public class Ex4While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		// 입력하는 한글자(char) 의 아스키코드값(10진수) 알아보기
		// s = "hello"		s.charAt(0) -> h	s.charAt(1) -> e
		
		while(true)
		{
			System.out.println("아무키나 눌러보세요");
			char ch=sc.nextLine().charAt(0); //입력한 문자열의 첫번째 글자(0번째)를 얻음
			System.out.println(ch+"=>"+(int)ch);
			
			if(ch=='q'||ch=='Q')
			{
				System.out.println("***종료합니다.***");
				break;
			}
		}
		
	}

}
