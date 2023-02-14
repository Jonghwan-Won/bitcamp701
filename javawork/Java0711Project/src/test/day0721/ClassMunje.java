package test.day0721;

public class ClassMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 문제 : 다음과 같이 호출할경우 오류없이 나오도록
		 * 생성자 및 setter & getter 메서드 및 일반 사용자 메서드 등을
		 * 추가해보세요
		 */
	
		MyShop []myShop=new MyShop[3];	// 메모리 할당만... 실제 생성이 아님
		System.out.println("** MyShop 3개의 배열 생성 **");
		//이때 실제 객체생성이 됨
		myShop[0]=new MyShop();
		myShop[1]=new MyShop("딸기");
		myShop[2]=new MyShop("사과",3,1000);
		
		System.out.println("0번 상품 변경하기");
		myShop[0].setSangpum("수박");
		myShop[0].setSu(3);
		myShop[0].setDanga(23000);
		
		System.out.println("1번 상품 변경하기");
		myShop[1].setSu(2);
		myShop[1].setDanga(7800);
		
		System.out.println("** 전체 상품 출력 **");
		MyShop.showTitle();		// 번호 상품명 수량 단가 총금액
		for(int i=0;i<myShop.length;i++)
		{
			System.out.print(i+1+"\t");
			myShop[i].writeShop();;
		}
		
	
	}

}
