package test.day0711;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// syso 하기 전 실행시키기
		// Run Coufigulation 에서 Ex2DataType 선택 -> arguments 탭 -> 7 5 입력 후 실행
		// args 라는 배열의 0번과 1번에 7과 5가 들어감
		
		System.out.println(args[0]+args[1]); //"7" + "5" = "75"
		
		// wrapper Class  : 타입 변환을 위한 크래스들
		// Integer, Long, Char. Boolean, Double 등등
		
		// String Type 을 기본형인 int Type 으로 변환하는 방법
		// 배열 args는 위에서 String 타입으로 선언?됨
		int su1=Integer.parseInt(args[0]);
		int su2=Integer.parseInt(args[1]);
		System.out.println(su1+su2);
		System.out.println(su1-su2);
		
		System.out.println("1"+2+3); //문자열부터 계산되므로 나열됨
		System.out.println("1"+(2+3)); //우선순에 따라 15가 됨
		
		// 2번 배열의 3.5 도 타입은 String
		// String -> double
		double su3=Double.parseDouble(args[0]);
		System.out.println(su3*2);
		
		
		
		
	}

}
