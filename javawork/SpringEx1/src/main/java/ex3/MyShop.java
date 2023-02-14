package ex3;

public class MyShop {
	private String sangpum;
	private int price;
	private String color;
	
	//상품만 생성자로 받고
	public MyShop(String sangpum) {
		super();
		this.sangpum = sangpum;
	}

	//나머지는 setter로 받기
	public void setPrice(int price) {
		this.price = price;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	//제대로 주입되었나 확인하기 위함
	public void showShop()
	{
		System.out.println("상품명:"+sangpum);
		System.out.println("가격:"+price);
		System.out.println("색상:"+color);
	}
	
	
}
