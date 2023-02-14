package test.day3;

public class Ex8MultiFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++)
		{
			System.out.println("i="+i);
			for(int j=1;j<=4;j++)
			{
				System.out.println("\tj="+j);
			}
			System.out.println("-----------");
		}
		System.out.println();
		
		for(int i=1;i<=3;i++)
		{
			System.out.println("i="+i);
		for(int j=1;j<=4;j++)
		{
			if(j==3)
				break; //현재 속한 for문을 빠져나간다
			System.out.println("\tj="+j);
		}
		System.out.println("-----------");
		}
		
	}

}
