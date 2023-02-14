package test.day0712;

import java.util.Scanner;

public class Ex3Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 키보드 입력을 하기 위한 클래스 생성
		// new 로 클래스를 생성하면 생기는 sc변수를 인스턴스 변수라고 한다.
		// 각 클래스의 인스턴스 메소드들은 이 인스턴스 변수가 있어야만 호출이 가능하다.
		// 예외 : static 메서드는 new 생성없이 클래스며으로 호출가능
		// 위 내용은 다음주 클래스 단원 배울때 다시 설명
		Scanner sc=new Scanner(System.in);
		String msg;
		System.out.println("메세지를 입력해보세요");
		msg=sc.nextLine();	// Line -> 엔터를 누를경우 그 한줄을 통째로 읽어온다(공백 포함)
		System.out.println("오늘의 메세지는 "+msg+" 입니다.");
		/*
		 *  \" : " 출력
		 *  \' : ' 출력
		 *  \\ : \출력
		 */
		System.out.println("오늘의 메세지는 \""+msg+"\" 입니다.");
		System.out.println("오늘의 메세지는 \'"+msg+"\' 입니다.");
		
		
		
	}

}
