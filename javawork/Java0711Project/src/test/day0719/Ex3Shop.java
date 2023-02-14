package test.day0719;

import java.util.Scanner;

public class Ex3Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Shop[] shop;
		int num;
		System.out.println("상품등록할 갯수는");
		num=Integer.parseInt(sc.nextLine());
		//메모리 할당
		shop=new Shop[num];
		for(int i=0;i<shop.length;i++)
		{
			System.out.println("상품명");
			String sang=sc.nextLine();
			System.out.println("수량");
			int su=Integer.parseInt(sc.nextLine());
			System.out.println("단가");
			int dan=Integer.parseInt(sc.nextLine());
			shop[i]=new Shop(sang,su,dan);
			System.out.println("상품을 등록했습니다");
		}
		
		for(Shop s:shop)
			s.calcTotal();	//수량*단가를 구해서 멤버변수 total에 구하기
		
		Shop.showTitle();	//상품   수량   단가  총금액
		for(Shop s:shop)
			s.writeShop();	//데이타 출력(sang,su,dan,total)
		
		System.out.print("\t전체 상품 금액 : ");
		System.out.println(Shop.getSangpumTotal(shop)+"원");
		
		System.out.println("수정할 배열 번호를 입력해주세요");
		int idx=Integer.parseInt(sc.nextLine());
		if(idx>=shop.length)
		{
			System.out.println("총 갯수는 "+shop.length+"개 입니다");
			System.out.println("0부터 "+(shop.length-1)+"까지만 가능합니다");
			return; // 메인함수 종료
		}
		System.out.println("수정할 상품명과 수량, 단가를 입력해주세요");
		String sang=sc.nextLine();
		int su=Integer.parseInt(sc.nextLine());
		int dan=Integer.parseInt(sc.nextLine());
		
		// 수정
		shop[idx].setSangpum(sang,su,dan);	// 한꺼번에 수정하는 메서드 만들기
		shop[idx].calcTotal();				// total 다시 구하기
		System.out.println("** 수정된 상품 출력 **");
		
		for(Shop s:shop)
			s.writeShop();

//		7/19 오후 2시 50분에 여기까지하고 vscode 하러 넘어감
//		jQuery 보다는 javaScript...
		
	}

}
