package test.day0712;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=5, b=5;
		// 단항일경우는 전치든 후치든 결과가 같다
		++a; //a=a+1, a+1 과 같다
		b++;
		System.out.println(a+","+b);
		
		int c,d;
		c=++a*3; //a가 먼저 증가 후 곱한다 c=21
		d=b++*3; //먼저 곱한 후 d가 증가된다 d=18
		
		System.out.printf("%d,%d,%d,%d\n",a,b,c,d);
		
		a=b=c=d=3;
		d=b++ + ++c*++a;
		System.out.println(d); //19
		
		a=3;
		System.out.println(a++); //3, 출력 후 증가, 메모리에는 4가 들어감
		System.out.println(++a); //5, 먼저 증가 후 출력
		
		
	}

}
