package test.day0713;

public class Ex11Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2단		3단		4단 	5단 	-> 단일 for
		// 2x1=2    3x1=3   4x1=4	5x1=5	-> 다중 for
		
		for(int i=2;i<=5;i++)
		{
			System.out.print(i+"단\t");
		}
		System.out.println("\n");
		
		for(int i=1;i<=9;i++)
		{
			for(int j=2;j<=5;j++)
			{
//				System.out.printf("%dx%d=%d\t",j,i,i*j);
				System.out.print(j+"x"+i+"="+i*j+"\t");
			}
			
			System.out.println();
		}
		
		
	}

}
