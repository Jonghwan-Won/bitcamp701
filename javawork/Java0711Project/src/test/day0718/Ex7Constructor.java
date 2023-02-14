package test.day0718;

import java.util.Scanner;

class Sawon
{
	private String name;
	private String jikwi;
	private int pay;
	
	Sawon(String name, String jikwi, int pay)
	{
		this.name=name;
		this.jikwi=jikwi;
		this.pay=pay;
		
	}
	
	public static void showTitle()		// Title 제목 클래스
	{
		System.out.println("사원명\t직위\t월급여\t");
		System.out.println("-------------------------------");
	}
	
	
	public void writeSawon()
	{
		System.out.println(name+"\t"+jikwi+"\t"+pay);
	}
	
}

////////////////////////////
public class Ex7Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 필요한 변수
		Scanner sc=new Scanner(System.in);
		int inwon;	// 인원수
		Sawon []sawon;	// 할당은 인원수 입력 후 할당
		String name, jikwi;
		int pay;
		
		// 인원수 입력
		System.out.println("사원수 입력");
		inwon=Integer.parseInt(sc.nextLine());
		
		// 사원 할당
		sawon=new Sawon[inwon];
		
		// 인원수만큼 데이터 입력 후 생성
		for(int i=0;i<sawon.length;i++)
		{
			System.out.println(i+1+"번째 데이터 입력");
			System.out.println("\t사원명");
			name=sc.nextLine();
			System.out.println("\t직위");
			jikwi=sc.nextLine();
			System.out.println("\t월급여");
			pay=Integer.parseInt(sc.nextLine());
			
			// i번째 사원 생성
			sawon[i]=new Sawon(name, jikwi, pay);
			
			
		}
		// 출력
		Sawon.showTitle(); // 제목부터 출력
		for(Sawon sa:sawon)
				sa.writeSawon();
				
	}

}
