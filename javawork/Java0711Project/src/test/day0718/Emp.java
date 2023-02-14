package test.day0718;

public class Emp {

	private String name;
	private int famSu;	// 가족수
	private int timeSu;	// 초과근무시간
	private int gibon;	// 기본급
	
	Emp(String name, int famSu, int timeSu, int gibon)	// 생성자
	{
		this.name=name;
		this.famSu=famSu;
		this.timeSu=timeSu;
		this.gibon=gibon;
	}
	
	public int getTimeSudang()	// 시간수당
	{
		//timeSu가 5시간 미만이면 timeSu*15000 리턴
		//5시간 이상이면 70000 리턴
		if(timeSu<5)
			return timeSu*15000;
		else
			return 70000;
		
	}
	
	public int getFamilySudang()	// 가족수당
	{
		//famSu가 3인 미만이면 가족수*50000
		//이상이면 무조건 130000 리턴
		if(famSu<3)
			return famSu*50000;
		else
			return 130000;
		
	}
	
	public int getNetPay()	// 실수령액
	{
		//기본급+가족수당+시간수당-세금(기본급의 3%)
		//위 계산한 결과를 리턴
		return gibon+getFamilySudang()+getTimeSudang()-(gibon*3/100);	// (int)(gibon*0.03) 형변환 가능
	}
	
	public static void showTitle()	// static 메서드
	{
		//제목 출력
		/*
		 * 		사원별 급여 정보
		 * 	사원명 가족수 가족수당 시간수 시간수당 기본급
		*/
		System.out.println("\t\t 사원별 급여 정보");
		System.out.println("사원명\t가족수\t가족수당\t시간수\t시간수당\t기본급\t실수령액");
		System.out.println("-----------------------------------------------------------------------");
	}
	
	
	public void sawonWrite()
	{
		//제목에 해당하는 각 데이터 출력(가로방향)
		System.out.println(name+"\t"+famSu+"\t"+getFamilySudang()+"\t\t"+timeSu+"\t"+getTimeSudang()+"\t\t"+gibon+"\t"+getNetPay());
		
//		System.out.printf("%-4s%6d%8d%7d%8d%8d%10d\n",name,famSu,getFamilySudang(),timeSu,getTimeSudang(),gibon,getNetPay());
	}
	
	
}




