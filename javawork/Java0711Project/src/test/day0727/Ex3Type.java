package test.day0727;

class GenericType<T>{
	T[] v;

	public void set (T[] n)
{
	v=n;
}

public void print()
{
	for(T s:v)
		System.out.println(s+" ");
	System.out.println();
}

}

public class Ex3Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//T는 모든 타입을 Generic으로 설정할 수 있다
		String []sarr= {"사과","오렌지","딸기"};	// String형 배열 선언
		GenericType<String> t1=new GenericType<>();
		t1.set(sarr);
		t1.print();
		
		Integer []narr= {90,89,100,78};				// Intger형 배열 선언
		GenericType<Integer> t2=new GenericType<>();
		t2.set(narr);
		t2.print();
		
	}

}
