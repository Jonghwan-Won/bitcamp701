package test.day0712;

import java.util.Scanner;

public class Ex13Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String name;
		int java, html, oracle, tot;
		double avg;
		// 이름과 3과목의 점수를 입력받아 tot(총점), avg(평균)을 구한 후
		// 평균이 60 이상이고, 3과목이 모두 40이상일 경우 "합격입니다"
		// 그렇지 않을 경우 "불합격입니다" 라고 출력 후
		// 이름과 총점, 평균을 추가로 출력하시오
		
		System.out.println("이름 입력");
		name=sc.nextLine();
		System.out.println("3과목 점수 입력");
		java=sc.nextInt();
		html=sc.nextInt();
		oracle=sc.nextInt();
		
//		System.out.println("java 점수 입력");
//		java=sc.nextInt();
//		System.out.println("html 점수 입력");
//		html=sc.nextInt();
//		System.out.println("oracle 점수 입력");
//		oracle=sc.nextInt();
		
		tot = java+html+oracle;
		avg = tot/3.0;
		
		//합격여부
		if(avg>=60 && java>=40 && html>=40 && oracle>=40)
			System.out.println("합격입니다.");
		else
			System.out.println("불합격입니다.");
		
		
		System.out.println("이름 : "+name);
		System.out.println("총점 : "+tot);
		System.out.printf("평균 : %5.1f",avg);
		
		
	}

}
