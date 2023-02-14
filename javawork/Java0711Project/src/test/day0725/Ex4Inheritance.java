package test.day0725;

class Super4
{
	private String sangpum;	//멤버변수
	private String ipgoday;

	// 우클릭 > source > Generate Constructor...using field > 체크 다 풀고 디폴트만
	public Super4() {
//		super();	//생략해도됨
	}

	// 우클릭 > source > Generate Constructor...using field > 둘 다 체크
	public Super4(String sangpum, String ipgoday) {
		super();
		this.sangpum = sangpum;
		this.ipgoday = ipgoday;
	}
	// 우클릭 > source > Generate Getter and Setter > Select Setters (Setter로 받아오기만 할거라서)
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public void setIpgoday(String ipgoday) {
		this.ipgoday = ipgoday;
	}

	@Override		// 우클릭 > source > generate toString
	public String toString() {
		return "Super4 [sangpum=" + sangpum + ", ipgoday=" + ipgoday + "]";
	}
	
	
	
}

//////////////////////////////////////
class Shop extends Super4
{
	private String color;
	private int price;
	
	// 우클릭 > source > Generate Constructor...using field > 체크 다 풀고 디폴트만
	public Shop() {
		super();
	}


	// 우클릭 > source > Generate Constructor...using field > Super4() 선택 후 필드값 모두 선택
	public Shop(String color, int price) {
		super();	//부모꺼는 디폴트 호출
		this.color = color;
		this.price = price;
	}
	// 우클릭 > source > Generate Constructor...using field > Super4(String,String) 선택 후 필드값 모두 선택
	public Shop(String sangpum, String ipgoday, String color, int price) {	
		super(sangpum, ipgoday);	//4개 받아서 부모한테 2개 보내는 생성자
		this.color = color;
		this.price = price;
	}

	
	// 우클릭 > source > Generate Getter and Setter > Select Setters (Setter로 받아오기만 할거라서)
	public void setColor(String color) {
		this.color = color;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	// generate toString에서 본인것과 밑에 부모꺼 toString까지 체크하면 이렇게 됨
	@Override
	public String toString() {
		return "Shop [color=" + color + ", price=" + price + ", toString()=" + super.toString() + "]";
	}

	
}

public class Ex4Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shop []s=new Shop[3];
		s[0]=new Shop();
		s[1]=new Shop("흰색",23000);
		s[2]=new Shop("반바지","2022-07-25","노랑색",12000);
		
		System.out.println("초기값 출력");
		for(Shop shop:s)
			System.out.println(shop);	//toString 호출
		
		System.out.println();
		System.out.println("** 값 변경후 다시 출력 **");
		s[0].setSangpum("자켓");
		s[0].setIpgoday("2022-10-10");
		s[0].setColor("회색");
		s[0].setPrice(34000);
		
		s[1].setSangpum("블라우스");
		s[1].setIpgoday("2022-08-10");
		
		for(Shop shop:s)
			System.out.println(shop);	//toString 호출
		
	}

}
