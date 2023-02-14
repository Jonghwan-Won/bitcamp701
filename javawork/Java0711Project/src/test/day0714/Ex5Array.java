package test.day0714;

public class Ex5Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 응용문제 1번
		int[] data= {6,14,87,65,36,77,23,52,60,19};
		int max=data[0];	// 첫번째값을 max에 대입 후 1번지부터 비교하면 됨
		System.out.println("**배열에서 최대값, 최소값 구하기**");
		
		Exit: // 원종환 풀이
			for(int i=1;i<data.length;i++)
				if(max<data[i]) {
					max=data[i];
				}
				else
					continue Exit;

		
		int min=data[0];
		Exit:
			for(int i=1;i<data.length;i++)
				if(min>data[i]) {
					min=data[i];
				}
				else
					continue Exit;
		
		
		System.out.println("최대값은 "+max);
		System.out.println("최소값은 "+min);
		
		
		// 선생님 풀이
		for(int i=1;i<data.length;i++)		// Exit: 랑 else 랑 continue 필요없음
		{  
			if(max<data[i]) 
				max=data[i];
			if(min>data[i])
				min=data[i];
		}


	}
}


