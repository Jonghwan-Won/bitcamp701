package test.day2;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 관계연산자, 논리연산자
		int kor=90, eng=100, mat=90;
		System.out.println(kor>eng);//false
		System.out.println(kor>eng||eng>mat);//true
		System.out.println(kor>eng&&eng>mat);//false
		System.out.println(!(eng>mat));//false
		System.out.println(eng==mat);//false
		System.out.println(eng==mat&&kor==mat);//flase
		System.out.println(eng==mat||kor==mat);//true
		
		//간단한 조건문
		if(kor>=90&&eng>=90&&mat>=90)
			System.out.println("합격!!!");
		else
			System.out.println("불합격!!!"); // 해당 조건문에서 조건이 한줄이므로 중괄호 생략 가능
		
	}

}
