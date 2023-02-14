package test.day0711;

public class Ex7Args {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * args : 강호동 182.5 98.7
		 * 
		 * 이름 : 강호동
		 * 키 : 182.5 Cm
		 * 몸무게 : 98.7 Kg
		 * 권장몸무게 : (키-100)*0.9 : 74.25 Kg
		 * 
		 * printf
		 * println 각각 출력
		 * 
		*/
		
		String name = args[0];
		double height = Double.parseDouble(args[1]);
		double weight = Double.parseDouble(args[2]);
		double kwon = (height-100)*0.9;
		
		System.out.printf("이름 : %s\n",name);
		System.out.printf("키 : %5.1f Cm\n",height);
		System.out.printf("몸무게 : %5.1f Kg\n",weight);
		System.out.printf("권장몸무게 : %5.2f Kg\n\n",kwon);
		
		System.out.println("이름 : "+name);
		System.out.println("키 : "+height+" Cm");
		System.out.println("몸무게 : "+weight+" Kg");
		System.out.println("권장몸무게 : "+kwon+ " Kg");
		
	}

}
