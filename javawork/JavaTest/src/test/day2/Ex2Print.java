package test.day2;

public class Ex2Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printf : 변환기호를 이용한 출력물(jdk5 에서 생김)
		// 변환기호 : 정수: %d, 실수: %f, 문자: %c, 문자열: %s
		
		int x=150;
		int y=200;
		// x=150px, y=200px 이렇게 출력을 해보자
		// println 활용
		System.out.println("x="+x+"px, y="+y+"px");
		// printf 활용 : 줄넘김:\n, 탭: \t
		System.out.printf("x=%dpx, y=%dpx\n",x,y); //%d에 순서대로 들어감 -> x, y
		System.out.printf("x=%dpx \ty=%dpx\n\n",x,y); //%d에 순서대로 들어감 -> x, y
		
		// 년월일 (정수 타입 출력)
		int year=2022;
		int month=5;
		int day=17;
		// 2022-5-17
		// println
		System.out.println(year+"-"+month+"-"+day);
		// printf
		System.out.printf("%d-%d-%d\n",year,month,day);
		// %02d : 2자리로 출력 (빈자리는 0으로 출력)
		System.out.printf("%d-%02d-%02d\n",year,month,day);
		
		
		// 실수 타입 출력
		double num=23.45678;
		System.out.printf("%f\n%10.2f\n%-10.2f*\n",num,num,num);
		//%10.2f : 10: 총 자릿수, 2: 소수점이하자릿수(반올림), - 여부는 왼쪽정렬 오른쪽정렬
		
		
		// 문자열 타입 출력
		String name="강호동";
		char blood='B'; //큰따옴표를 주는 순간 char가 아닌 String으로 인식함
		//강호동님의 혈액형은 B형입니다.
		System.out.println(name+"님의 혈액형은 "+blood+"형입니다.");
		System.out.printf("%s님의 혈액형은 %c형입니다.\n",name,blood);
		// name은 "으로 기재된 String(문자열)이므로 %s
		// blood는 '으로 기재된 char(문자)이므로 %c
		
		String shop="** 여성의류센타 **";				
		System.out.println("\t\t"+shop);
		System.out.printf("%30s\n",shop);
		
		System.out.println("The End!!");
		
		
		
	}

}
