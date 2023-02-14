package test.day3;

public class Ex13While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=1;
		while(a<=5)
		{
			System.out.println(a++); //후치 a++이므로 출력하고 증가
		}
		
		System.out.println();
		
		a=1;
		while(true)
		{
			System.out.println(a++);
			if(a>5)
				break; //조건이 ture이므로 계속 도니까 반드시 break 넣어줘야함
		}
		
		System.out.println();
		a=1;
		while(a++<5) //비교하고 증가 (후치) ex: 1일때 비교하고 성립 → 증가시킨 후 출력
		{
			System.out.println(a);
		}
		
		//while문으로 a-z 출력
		a=65;
		while(a<=90)
		{
			System.out.print((char)a++); // 후치이므로 출력하고 증가
		}
		
		System.out.println();
		
		a=65;
		while(true)
		{
			System.out.print((char)a++);
			if(a>90)
				break;
		}
		
		
	}

}
