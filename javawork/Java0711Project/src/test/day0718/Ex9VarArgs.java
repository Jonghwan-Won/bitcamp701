package test.day0718;

public class Ex9VarArgs {

	// ... 연산자 : 같은 타입으로 갯수상관없이 받을 수 있다 (배열)
	public static void sum(int ...n)
	{
		int hap=0;
		for(int i=0;i<n.length;i++)
		{
			System.out.println(n[i]+"\t");
			hap+=n[i];
		}
		
		System.out.println();
		System.out.println("총 합:"+hap);
		System.out.println("------------------");
		
	}
	
	public static void writeColor(String ...color)
	{
		System.out.println("총 "+color.length+"개");
		for(String s:color)
			System.out.println(s+" ");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sum(2,4);
		sum(4,10,20,4,6,8);
		sum(100);
		
//		static 이니까 클래스명으로 호출하는데 생략가능
		
		writeColor("red");
		writeColor("yellow","orange");
		writeColor("red","pink","gray","magenta");
		
		
		
	}

}
