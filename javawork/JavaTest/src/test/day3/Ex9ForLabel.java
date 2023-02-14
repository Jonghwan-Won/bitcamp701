package test.day3;

public class Ex9ForLabel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exit:
			for(int i=1;i<=5;i++)
			{
				for(int j=1;j<=5;j++)
				{
					System.out.println("i="+i+",j="+j);
					if(i==3 && j==3)
						break Exit;
				}
			}
		System.out.println("**종료**");
	}

}
