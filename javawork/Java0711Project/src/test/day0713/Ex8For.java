package test.day0713;

public class Ex8For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=3;i++)
		{
			System.out.println("Hello~");
			for(int j=1;j<=4;j++)
				System.out.print("Kitty!");
			System.out.println();
		}
		
		System.out.println("---------------------");
		
		
		Exit:		//rable 에 이름 부여
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=3;j++)
			{
				System.out.println("i="+i+", j="+j);
				if(j==3)
//					break;	//현재 속한 for문만 빠져나온다
					break Exit;		// 2개의 for문을 한번에 빠져나온다
					
			}
		}
		
	}

}
