package test.day0714;

public class Ex13ArrayAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int []data= {3,43,23,35,41,7,9,16,18,20,24,35,
				39,49,29,38,9,11,46,37};
		
//		System.out.println(data.length); 
		// data 배열에 데이터 넣는 중간에 실행시켜보면 몇개 넣었는지 확인 가능
		
		int []age= new int[5];
		
		/*
		 * age 배열에 data에서 연령을 체크하여 인원수를 구하라
		 * age[0]=1~9 세 인원구하기
		 * age[1]=10~19 세 인원구하기
		 * age[2]=20~29 세 인원구하기
		 * age[3]=31~39 세 인원구하기
		 * age[4]=41~49 세 인원구하기
		 * 
		 * 출력양식 (예시)
		 * 어린이 : 2명
		 * 10 대 : 3명
		 * 20 대 : 4명
		 * 30 대 : 2명
		 * 40 대 : 6명
		 *
		*/
		
						
		for(int i=0;i<data.length;i++)		// data배열의 길이만큼 반복
		{
			age[data[i]/10]++;				// i=0일때 (3)  10으로 나눈 몫 = 0 이므로 age[0] 의 숫자 증가
											// 1=1일때 (43) 10으로 나눈 몫 = 4 이므로 age[4] 의 숫자 증가

		}
		
		
		System.out.println("연령별 인원 수 구하기");
		
		for(int i=0;i<age.length;i++)
		{
			System.out.printf("%s : %d명\n",i==0?"어린이":i*10+"대",age[i]);
		}
		
	}

}
