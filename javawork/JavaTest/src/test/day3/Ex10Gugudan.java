package test.day3;

public class Ex10Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int dan=2;dan<=9;dan++)
		{
			System.out.printf("** %d단 **\n",dan);
			for(int i=1;i<=9;i++)
				System.out.printf("%d x %d = %2d\n",dan,i,dan*i);
			System.out.println();
		}
		
	}

}
