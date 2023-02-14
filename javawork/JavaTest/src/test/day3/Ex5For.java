package test.day3;

public class Ex5For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1~10까지 출력");
		
		for(int i=1;i<=10;i++)
			System.out.printf("%3d",i);
		
		//만약 for( ); 끝에 세미콜론 넣으면 한문장으로 인식해서 끝나고
		//for 안에서 int i를 선언했기때문에 빠져나가면 i라는 변수는 사라짐
		//그렇기 때문에 아래 출력 명령어는 오류남 
		
		System.out.println(); //한 줄 띄기
		//for문에 중괄호를 하지않아 명령 하나만 실행함
		
		System.out.println("10~1까지 출력");
		for(int i=10;i>=1;i--)
			System.out.printf("%3d",i); //%3d는 자릿수 맞추기임 (총 3칸)
		System.out.println();
		
		System.out.println("1,3,5,7....19");
		for(int i=1;i<=20;i+=2) // i+=2 자리에는 증감 아니면 대입연산자만 가능
			System.out.printf("%3d",i);
		System.out.println();

		System.out.println("1~30 까지중 3의 배수를 제외하고 출력");
		for(int i=1;i<=30;i++)
		{
			if(i%3==0)
				continue; // 증감식 i++로 이동
			System.out.printf("%3d",i);
			
		}
		System.out.println();
		
		//A~Z까지 옆으로 출력
		System.out.println("A~Z까지 출력");
		for(int i='A';i<='Z';i++) //int 이기 때문에 A를 쓰면 아스키코드 번호로 인식
			System.out.print((char)i);
		System.out.println();
		  //그냥 i로 하면 아스키코드 숫자출력됨
		  //System.out.print(i);
		
		
		for(char i='A';i<='Z';i++) //int 이기 때문에 A를 쓰면 아스키코드 번호로 인식
			System.out.print(i);
		System.out.println();
	}

}
