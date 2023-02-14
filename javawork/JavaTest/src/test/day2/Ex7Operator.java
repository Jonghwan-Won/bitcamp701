package test.day2;

public class Ex7Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 조건 연산자 : 조건식?참일때값:거짓일때값
		//			 조건식1?참일때값:조건식2?참일때값:거짓일때값 (조건이 여러개인 경우)
		int a=35, b=23, max;
		max=a>b?a:b;  	// a, b 중 더 큰값을 max에 저장
		System.out.println("max="+max);
		System.out.println("a가 더 "+(a>b?"크다":"작다"));
		
		int score=95;
		//90이상이면 "Excellent!!"
		//80이상이면 "Good!!"
		//그 나머지는 "Try!!"
		String msg;
		msg=score>=90?"Excellent!!":score>=80?"Good!!":"Try!!";
		System.out.println(score+"점은 "+msg);
		
		char grade;
		//grade 에 학점구하기(90이상이면 'A', 80이상이면 'B', 70이상이면 'C'
		//60이상이면 'D', 그 나머지는 'F'
		//출력 예시 : 78점은 C학점 입니다. - printf 로 출력해보기	
		
		grade=score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F';
		System.out.printf("%d점은 %c학점 입니다.\n",score,grade);
		// grade는 char 문자이기때문에 %c로 진행 ''
	}

}
