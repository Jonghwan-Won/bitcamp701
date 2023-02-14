package test.day0718;

class Orange
{
	String color;
	int price;
	
	Orange(String color, int price)
	{
		this.color=color;
		this.price=price;
		
	}
	
	Orange()
	{
		this("빨강",1000);	// 인자가 2개인 생성자 호출, 첫줄!!
		
	}
	
	Orange(String color)
	{
		this(color, 500);
	}
	
	
	public void write()
	{
		System.out.println("색상 : "+color+", 수량 : "+price);
	}
}

public class Ex6Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Orange [] or=new Orange[5];
		or[0]=new Orange();
		or[1]=new Orange("파랑");
		or[2]=new Orange("오렌지",300);
		or[3]=new Orange();
		or[4]=new Orange("노랑");
		
		System.out.println("총 "+or.length+"개");
		System.out.println("출력");
		
		for(Orange o:or)
			o.write();
		
		
	}

}
