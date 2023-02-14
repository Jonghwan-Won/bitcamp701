package test.day0719;

public class Shop {
	private String sang;
	private int su;
	private int dan;
	private int total;
	
	public Shop(String sang,int su,int dan)
	{
		this.sang=sang;
		this.su=su;
		this.dan=dan;		
	}
	
	public void calcTotal()
	{
		total=su*dan;
	}
	
	public static void showTitle()
	{
		System.out.println("\t\t**전체 상품**\n");
		System.out.println("상품명\t수량\t단가\t총금액");
		System.out.println("----------------------------------");
	}
	
	public void writeShop()
	{
		System.out.println(sang+"\t"+su+"\t"+dan+"\t"+total);
	}
	
	
	public static int getSangpumTotal(Shop []shop)		// void = 리턴타입이 없다
	{
		int sum=0;
		for(int i=0;i<shop.length;i++)
			sum+=shop[i].total;
		return sum;
	}
	
	public void setSangpum(String sang, int su, int dan)
	{
		this.sang=sang;
		this.su=su;
		this.dan=dan;
	}
	
	
}


