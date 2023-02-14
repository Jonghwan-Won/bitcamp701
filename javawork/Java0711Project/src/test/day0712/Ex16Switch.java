package test.day0712;

import java.util.Scanner;

public class Ex16Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String color;
		System.out.println("색상을 영문으로 입력");
		color=sc.nextLine();
		/*
		 * red, RED -> 빨강색
		 * green, GREEN -> 초록색
		 * pink, PINK -> 분홍색
		 * 그 이외는 "빨강, 초록, 분홍은 아닙니다"
		 * 
		 * if문, switch 로 둘다 출력하기
		 * 문자열은 비교시 == (동등연산자) 사용 못함 (equals 로 값을 비교)
		 * a.equals(b) : a와 b가 같을 경우 true
		 */

		System.out.println("** if문으로 문자열 비교 **");
		

		if(color.equals("red") || color.equals("RED"))
			System.out.println("빨강색!!");
		else if(color.equals("green") || color.equals("GREEN"))
			System.out.println("초록색!!");
		else if(color.equals("pink") || color.equals("PINK"))
			System.out.println("분홍색!!");
		else 
			System.out.println("빨강, 초록, 분홍은 아닙니다.");

		
		System.out.println("\n** switch문으로 문자열 비교 **");
		switch(color)
		{
		case "red":
		case "RED":
			System.out.println("빨강색!!"); break;

		case "green":
		case "GREEN":
			System.out.println("초록색!!"); break;

		case "pink":
		case "PINK":
			System.out.println("분홍색!!"); break;
		default:
			System.out.println("빨강, 초록, 분홍은 아닙니다.");

		}

	}
}
