package test.day0712;

import java.util.Scanner;

public class Ex4Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String name;
		int age;
		System.out.println("이름과 나이 입력");
		name=sc.next(); //문자열 한 단어만 읽기
		age=sc.nextInt();
		System.out.println(name+"님은 "+age+"세 입니다.");
		
	}

}
