package test.day0719;

import java.util.Scanner;

public class Ex2Chajum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		OxChaejum[] cha;
		int inwon;
		//인원수 입력
		System.out.println("인원수 입력");
		inwon=Integer.parseInt(sc.nextLine());
		
		//인원수만큼 cha 할당
		cha=new OxChaejum[inwon];
		
		//for문으로 이름과 답입력후 생성자호출
		for(int i=0;i<cha.length;i++)
		{
			System.out.println(i+1+"번 데이타");
			System.out.println("이름과 답(5개)를 입력해주세요");
			String name=sc.nextLine();
			String dap=sc.nextLine();
			//객체 생성
			cha[i]=new OxChaejum(name, dap);
		}
		//인원수만큼채점
		for(OxChaejum a:cha)
			a.check();
		
		//등수구하기
		OxChaejum.getRank(cha);
		
		//제목출력
		OxChaejum.showTitle();
		
		//데이타출력
		for(OxChaejum a:cha)
			a.writeChaejum();
	}

}
