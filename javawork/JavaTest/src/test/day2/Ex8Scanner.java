package test.day2;

import java.util.Scanner;

public class Ex8Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String, System 클래스 지금까지 사용한 것 처럼 Scanner 사용
		// java.lang 이라는 패키지가 있고 그 안에 Scanner 클래스가 있음 
		// 기본패키지가 아니기때문에 사용하려면 import 필요함 
		
		
		// scanner 불러오면(ctrl + space) 자동으로 상단에 import됨
		Scanner sc=new Scanner(System.in); //키보드로 읽기위한 선언
		// 변수선언->입력->계산->출력
		String name;
		int age;
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();  //next 는 단어, nextline 는 한 줄 (ex. 홍 길동)
							// sc. 까지 입력하면 sc가 사용할 수 있는 메소드 목록이 나옴
		System.out.println("나이를 입력하세요");
		age=sc.nextInt();
		System.out.println(name+"님의 나이는 "+age+"살 입니다.");
		
		// + 심화
		System.out.println(name+"님은 "+(age>=20?"성인":"미성년자")+"입니다.");
		

		
	}

}
