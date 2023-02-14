package test.day3;

import java.util.Scanner;

public class Ex3Switch {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("색상 단어 입력");
		//입력한 색상명을 무조건 소문자로 변경 -> toLowerCase();
		String color=sc.nextLine().toLowerCase();
		//jdk8부터 switch에서 String 도 가능
		
		switch (color) {
		case "red":
			System.out.println("빨강색");
			break;
		case "green":
			System.out.println("초록색");
			break;
		default:
			System.out.println("그 이외의 색");
//			System.out.println(color);
//			System.out.printf("%s",color);
			break;
		}
				
	}
}
