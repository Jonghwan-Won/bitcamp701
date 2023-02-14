package test.day0718;

class MyMath
{
	public static int abs(int n)
	{
		return n<0?-n:n;
	}
	
	public static double abs(double n)
	{
		return n<0?-n:n;
	}
	
	public static float abs(float n)
	{
		return n<0?-n:n;
	}
	
	public static int pow(int a,int b)
	{
		//a의b승의 결과를 리턴
		int r=1;
		for(int i=1;i<=b;i++)
			r*=a;
		return r;
	}
	
	public static void star(int n,char ch)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
	public static void star(int n)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
public class Ex2Overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MyMath.abs(-10));
		System.out.println(MyMath.abs(6));
		System.out.println(MyMath.abs(-8.9));
		System.out.println(MyMath.abs(5.6f));
		System.out.println("3의 4승은 "+MyMath.pow(3,4)+"입니다");
		
		//리턴값이 없는 메서드 호출
		MyMath.star(3,'*');
		MyMath.star(5);
		MyMath.star(5,'#');
	}

}
