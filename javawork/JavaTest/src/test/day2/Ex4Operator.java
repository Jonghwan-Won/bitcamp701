package test.day2;

public class Ex4Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 산술연산자 : +,-,*,/,%
		int a=7, b=4;
		System.out.printf("%d+%d=%d\n",a,b,a+b);
		System.out.printf("%d-%d=%d\n",a,b,a-b);
		System.out.printf("%d*%d=%d\n",a,b,a*b);
		System.out.printf("%d/%d=%d\n",a,b,a/b); // 정수/정수=정수
		System.out.printf("%d/%d=%3.1f\n",a,b,(double)a/b);
		// 실수(double)/정수(int)=실수(double)
		// 변수 선언을 둘 중 하나만 double로 해도되지만, int로 둔다고했을때 (double)강제형변환으로 일회성 활용 가능
		System.out.printf("%d%%%d=%d\n\n",a,b,a%b); //%를 실제로 출력하려면 두번쓰면 문자로 인식_%%
	
		int money=2345600;
		System.out.printf("만원짜리 %d장\n",money/10000); //1만으로 나눈 몫
		System.out.printf("천원짜리 %d장\n",money%10000/1000); //1만으로 나눈 나머지를 1천으로 나눈 몫
		System.out.printf("백원짜리 %d개\n",money%1000/100);
		System.out.printf("십원짜리 %d개\n",money%100/10);
		System.out.printf("일원짜리 %d개\n",money%10/1);
		
		
		
	}

}
