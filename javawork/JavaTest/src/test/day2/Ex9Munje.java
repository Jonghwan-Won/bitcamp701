package test.day2;

import java.util.Scanner;

public class Ex9Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
			상품명과 수량 단가를 입력받아 총금액을 출력하는데
			수량이 5개 이상일경우에는 10% 할인된 금액을 출력
			
			(예)
			상품명 입력
			사과
			수량 입력
			6
			단가 입력
			1000
			
			사과 6개는 5400원입니다.
		*/

		
		// 변수선언->입력->계산->출력
		
		Scanner sc=new Scanner(System.in);
		
		String sang; //상품명
		int su, dan, total; // 수량, 단가, 합계액

		System.out.println("상품명을 입력하세요");
		sang=sc.nextLine();
		System.out.println("수량을 입력하세요");
		su=sc.nextInt();
		System.out.println("단가를 입력하세요");
		dan=sc.nextInt();

//		total=su>=5?su*dan*9/10:su*dan;  -> 삼항연산자를 if문으로 변경하기
		if(su>=5)
			total=su*dan*9/10;
		else
			total=su*dan;
		
		/*
		 * 방법 2가지
		 * total=su*dan*9/10
		 * total=(int)(su*dan*0.9)
		 * 
		 * 위 방법으로 하는 이유는 total 은 int이고 0.9는 double 이기때문에
		 * 9를 곱하고 10으로 나누거나
		 * 0.9를 곱한 값을 강제 형변환 (int) 처리하는 것
		*/

		
		System.out.println(sang+" "+su+"개는 "+total+"원 입니다.");
//				printf 방식으로 해보기
//				System.out.printf("%s %d개는 %d원 입니다.\n",sang,su,total);

		
		
	}

}
