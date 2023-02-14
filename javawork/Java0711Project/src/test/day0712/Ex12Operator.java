package test.day0712;

import java.util.Scanner;

public class Ex12Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String name, ddi;
		int year;
		//이름과 태어난 년도 입력
		System.out.println("이름");
		name=sc.nextLine();
		System.out.println("태어난 년도");
		year=sc.nextInt();
		
		//태어난 년도에 따라 띠를 구해보자
		//힌트 : 서기 1년은 닭띠해이다. %12==1 닭띠
		
		//나머지 구하기
		int mod=year%12;
		//띠 구하기
		ddi=mod==1?"닭":mod==2?"개":mod==3?"돼지":mod==4?"쥐":
			mod==5?"소":mod==6?"호랑이":mod==7?"토끼":mod==8?"용":
			mod==9?"뱀":mod==10?"말":mod==11?"양":"원숭이";
		
		System.out.printf("%d년생은 %s띠 입니다.\n",year,ddi);
		
		
		
		
		
	}

}
