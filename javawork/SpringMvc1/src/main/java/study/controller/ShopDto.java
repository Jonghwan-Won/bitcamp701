package study.controller;

public class ShopDto {

	private String sangpum;
	private String color;
	private int price;
	
	public ShopDto(String sangpum, String color, int price) {
		super();
		this.sangpum = sangpum;
		this.color = color;
		this.price = price;
	}

	public String getSangpum() {
		return sangpum;
	}

	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
