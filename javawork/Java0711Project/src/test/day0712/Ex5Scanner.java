package test.day0712;

import java.util.Scanner;

public class Ex5Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String name;
		int age;
		System.out.println("나이");
		age=sc.nextInt();
		// 나이를 age가 읽은 후 엔터문자가 키보드 버퍼라는 곳에 저장
		// 문자열은 키보드버퍼가 비어있어야 비로소 키보드로 읽는다
		sc.nextLine(); //엔터를 읽어서 소멸
		System.out.println("이름");
		name=sc.nextLine();
		System.out.println(name+"님의 나이는 "+age+"세 입니다.");
		
		
		// int 먼저받고 String 받으면 위 현상 발생함
		// Ex4Scanner 처럼 String 이름 먼저 받고 int 나이 받으면 문제 없음
		// 정리 : int age를 키보드로 입력 받을 때 숫자 + 엔터 공백도 갖고있으므로
		//        sc.nextLine(); 으로 갖고있는 엔터 공백을 소모시켜야 함
	}

}
