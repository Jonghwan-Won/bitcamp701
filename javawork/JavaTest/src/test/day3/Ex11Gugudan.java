package test.day3;

public class Ex11Gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int dan=2;dan<=9;dan++)
			System.out.printf("[%d단]\t\t",dan);
		System.out.println();
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=2;dan<=9;dan++)
				System.out.printf("%dx%d= %2d\t\t",dan,i,dan*i);
			System.out.println();
		}
		
	}

}
