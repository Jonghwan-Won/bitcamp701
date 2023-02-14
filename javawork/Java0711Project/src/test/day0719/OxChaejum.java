package test.day0719;

public class OxChaejum {
	public static final String JUNGDAP="12124";
	private String dap;
	private char[] ox=new char[5];
	private String name;
	private int score;
	private int rank;
	
	public OxChaejum(String name,String dap)
	{
		this.name=name;
		this.dap=dap;
	}
	
	public void check()//ox와 score 구하기
	{
		for(int i=0;i<dap.length();i++)
		{
			char d=dap.charAt(i);
			char j=JUNGDAP.charAt(i);
			if(d==j)//정답일경우 O를 배열에 넣고 점수에 20점 추가
			{
				ox[i]='O';
				score+=20;
			}else {
				ox[i]='X';
			}
		}
	}
	
	//등수구하기-점수가 모두 구해진다음에 호출
	public static void getRank(OxChaejum [] stu)
	{
		for(int i=0;i<stu.length;i++)
		{
			stu[i].rank=1;
			for(int j=0;j<stu.length;j++)
			{
				if(stu[i].score<stu[j].score)
					stu[i].rank++;
			}
		}
	}
	
	//제목
	public static void showTitle()
	{
		System.out.println("이름       채 점       점수   등수");
		System.out.println("------------------------------------");
	}
	
	//데이타 출력
	public void writeChaejum()
	{
		System.out.print(name+"\t");
		for(char a:ox)
			System.out.printf("%3c",a);
		System.out.println("\t"+score+"\t"+rank);
	}	
}