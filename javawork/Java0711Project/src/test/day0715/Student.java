package test.day0715;

public class Student {

	// 모든 멤버 변수 private
	private String name;
	private int kor, eng, mat;
	
	
	// 생성자도 Public 이어야 다른 패키지에서 생성 가능
	public Student()
	{
//		System.out.println("Student 디폴트 생성자");
		name="이름없음";
		kor=10;
		eng=10;
		mat=10;
		
	}
	
	public Student(String name, int kor, int eng, int mat) //파라미터
	{
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		
	}
	
	public void write()
	{
		System.out.println("이름 : "+name);
		System.out.println("3과목점수 : "+kor+","+eng+","+mat);
		System.out.println("총점: "+getTotal());
		System.out.println("평균: "+getAverage());
		System.out.println("-----------------------------------");
		
	}
	
	public int getTotal()
	{
		return kor+eng+mat;
	}
	
	
	public double getAverage()
	{
		return getTotal()/3.0;
		
	}
	
}

