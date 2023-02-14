package test.day0726;

public class Ex6Exception {
	
	public static void main(String[] args) {
		
		int []arr= {3,5,6,8,10};
		for (int i=0;i<=arr.length;i++)
			// i<arr.length 를 해서 5번째인 arr[4]까지만 해야하지만 
			// =을 붙여서 배열크기를 초과하여 Exception 오류 발생함
		{
			try {
				System.out.println(arr[i]);
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 범위를 벗어났어요!"+e.getMessage());
//				e.printStackTrace();	//에러 추적 - 라인번호 출력
			}
			
		}
		
		System.out.println("** 정상종료 **");
	}

}
