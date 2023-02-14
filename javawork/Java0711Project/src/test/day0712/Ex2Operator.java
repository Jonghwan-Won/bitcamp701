package test.day0712;

public class Ex2Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 산술연산자
		int su1=7, su2=4;
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
		System.out.printf("%d+%d=%d\n",su1,su2,su1-su2);
		System.out.printf("%d+%d=%d\n",su1,su2,su1*su2);
		System.out.printf("%d+%d=%d\n",su1,su2,su1/su2);
		System.out.printf("%d/%d=%1.1f\n",su1,su2,(double)su1/su2);
		//나머지 %, printf에서 %출력 시 %% 두번쓴다
		System.out.printf("%d%%%d=%d\n",su1,su2,su1%su2);
		System.out.println(su1+"%"+su2+"="+su1%su2);
		
		//대입연산자 =, +=, -=, *=, /=, %=
		int a=10;
		a+=2; //a=a+2
		System.out.println(a); // 12
		a-=3; //a=a-3
		System.out.println(a); // 9
		a*=5;
		System.out.println(a); // 45
		a/=2;
		System.out.println(a); // 22
		a%=2;
		System.out.println(a); // 0
		
	
	}

}
	