package test.day0718;

import java.util.Scanner;
import test.day0718.Emp;

// Student.java 와 Ex4Constructor.java 참고
// Ex7Constructor.java 참고

public class Ex10ClassEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int inwon;
		Emp []emp;
		
		
		// 1. 인원수 입력
		System.out.println("인원수 입력");
		inwon=Integer.parseInt(sc.nextLine());	// 후에 문자열을 받아야해서 키보드버퍼 enter 방지를 위해 nextLine으로 받음
		
		// 2. 인원수만큼 emp 할당
		emp=new Emp[inwon];
		
		// 3. 인원수만큼 각 데이타 입력
		for(int i=0;i<emp.length;i++)
		{
			System.out.println(i+1+"번째 정보 입력");
			System.out.print("\t사원명: ");
			String name=sc.nextLine();
			System.out.print("\t가족수 : ");
			int famSu=Integer.parseInt(sc.nextLine());
			System.out.print("\t초과 시간 : ");
			int timeSu=Integer.parseInt(sc.nextLine());
			System.out.print("\t기본급 : ");
			int gibon=Integer.parseInt(sc.nextLine());
			
			emp[i]=new Emp(name, famSu, timeSu, gibon);
					
		}
		
		
		// 4. 전체 사원 급여정보 출력 (제목포함)

		Emp.showTitle();
		for(Emp e:emp)
			e.sawonWrite();
		
		
	}

}



//실행
//
//사원수?
//4
//
//1번 사원 정보
//	이름 : 강호동
//	가족수 : 5
//	초과시간근무 : 3
//	기본급 : 2350000
//	
//2번 사원 정보
//	이름 : 이영자
//	가족수 : 3
//	초과시간근무 : 5
//	기본급 : 3550000
//	
//	....
//	
//	사원명 가족수 가족수당 초과시간 시간수당 기본급 세금 실수령액
//	--------------------------------------------------------------
//	강호동 5	  