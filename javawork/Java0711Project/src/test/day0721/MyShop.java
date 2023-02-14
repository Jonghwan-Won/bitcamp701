package test.day0721;

public class MyShop {
	private String sangpum;
	private int su;
	private int danga;	

	public MyShop()
	{
		
	}
	public MyShop(String sangpum)	// 최초에만 사용
	{
		this.sangpum=sangpum;
	}
	public MyShop(String sangpum,int su, int danga)
	{
		this.sangpum=sangpum;
		this.su=su;
		this.danga=danga;
	}
	
	
	// setter만들기 : 중간에 변경하는경우
	public void setSangpum(String sangpum)
	{
		this.sangpum=sangpum;
	}
	public void setSu(int su)
	{
		this.su=su;
	}
	public void setDanga(int danga)
	{
		this.danga=danga;
	}
	
	
	// 제목 title
	public static void showTitle()
	{
		// 번호 상품명 수량 단가 총금액
		System.out.println("\t상품 목록");
		System.out.println();
		System.out.println("번호\t상품명\t수량\t단가\t총금액");
		System.out.println("--------------------------------------");
	}
	
	// 출력
	public void writeShop()
	{
		System.out.println(sangpum+"\t"+su+"\t"+danga+"\t"+su*danga);
	}
	
}
