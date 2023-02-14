package test.day0714;

public class Ex3Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1=new int[3];
		int[] arr2= {3,6,8,10,20}; // 초기값 지정하면 자동 할당
		
		System.out.println("**arr1**");
		for(int i=0;i<arr1.length;i++)
			System.out.println(i+":"+arr1[i]);
		System.out.println();
		
		for(int i=0;i<arr2.length;i++)
			System.out.println(i+":"+arr2[i]);
		System.out.println();
		
		System.out.println("** arr1에 10,20,30 넣기 **");
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		for(int i=0;i<arr1.length;i++)
			System.out.println(i+":"+arr1[i]);
		
	}

}
