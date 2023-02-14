package test.day0712;

import java.util.Scanner;

public class Ex6Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String sang, color;
		int price;
		System.out.println("상품명");
		sang=sc.nextLine();
		System.out.println("가격");
		// price=sc.nextInt();
		// 숫자도 문자열로 읽은 후 int로 변환하면 엔터를 읽는 문제 해결됨		
		price=Integer.parseInt(sc.nextLine());
		System.out.println("색상명");
		color=sc.nextLine();
		System.out.println(sang+" 상품은 "+price+"원 이고, 색상은 "+color+"색 입니다.");
		
	}

}
