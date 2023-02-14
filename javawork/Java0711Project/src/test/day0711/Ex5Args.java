package test.day0711;

public class Ex5Args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// args: 송혜교 67 78 82 이렇게 값을 준 후
		// 이름은 String name에 저장
		// 3과목의 정수는 int kor, eng, mat 에 저장 후 
		// 총점(int tot), 평균(double avg) 를 계산 후
		// printf를 이용해서 출력하시오
		
		// 1. Run coufiguration 을 통해 args 배열에 값 부여
		
//		String name=new String(args[0]); 	//String 으로 선언?하기때문에 변환 필요없이 아래처럼 하면됨
		String name=args[0]; 
		int kor=Integer.parseInt(args[1]);
		int eng=Integer.parseInt(args[2]);
		int mat=Integer.parseInt(args[3]);
		
		//총점
		int tot=kor+eng+mat;
		//평균
		double avg=(double)tot/3;
		//double avg=tot/3.0; 위와 같은 결과임
		//계산 식에서 tot 또는 나누는 값(3) 둘 중 하나만 double로 바꿔주면 됨
		
		System.out.printf("이름 : %s\n",name);
		System.out.printf("총점 : %d\n",tot);
		System.out.printf("평균 : %-5.1f\n",avg);
		
	}

}
