package test.day2;

public class Ex3Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 증감연산자
		// ++a:전치증감연산(1순위), a++:후치증감연산(끝순위):단 단항일경우는 상관없음
		int a=5, b=5;
		int m,n;
		a++;
		++b;
		System.out.println(a+","+b);
		
		m=a++; //먼저 대입 후 증가
		n=++b; //먼저 증가 후 대입
		System.out.printf("a=%d, b=%d, m=%d, n=%d\n",a,b,m,n);
		
		a=b=m=n=3;
		a=++b- --m*n++; //빼기와 전치를 구분하기위해 띄어쓰기 필요 -> 붙이면 전자에 대한 후치인지 알수없음
		System.out.printf("a=%d, b=%d, m=%d, n=%d",a,b,m,n);
		
		a=1;
		System.out.println(a++); //1: 출력 후 증가 (메모리에 2로 저장)
		System.out.println(++a); //3: 증가 후 출력 (메모리에 저장된 2에 +1 하고 출력)
		
	}

}
