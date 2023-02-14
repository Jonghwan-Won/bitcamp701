package test.day0719;

public class Student {

	private String name;
	private String hakbun;
	private int score;
	
	public Student()	// 같은 패키지라서 public 안붙여도되지만, 
	{}					// 다른 패키지에서 쓰려면 필요, 이번에는 그냥 쓰는걸로
	
	public Student(String name)
	{
		this.name=name;
	}
	
	public Student(String name, String hakbun, int score)
	{
		this.name=name;
		this.hakbun=hakbun;
		this.score=score;
	}
	
	// Ex1Constructor.java 에서 유형이 3가지임
	// 배열에 디폴트 생성자 (), name(이름)만 들어간거, name/hakbun/score 모두 들어간거
	// 그래서 세개 쓴것으로 보임
	
	public static void showTitle()	// 제목(Title) 출력
	{
		System.out.println("이름\t학번\t점수\t학점");
		System.out.println("-----------------------------------");
	}
	
	public void writeStudent()
	{
		System.out.println(name+"\t"+hakbun+"\t"+score+"\t"+getGrade());
	}

	
	public char getGrade()
	{
		char grade=score>=90?'A':score>=80?'B':score>=70?'C':score>=60?'D':'F';
		return grade;
		
		
		// score 점수에 따라 A,B,C,D,F 학점 구해서 리턴
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setHakbun(String hakbun)
	{
		this.hakbun=hakbun;
	}

	public void setScore(int score)
	{
		this.score=score;
	}
	
	public void setData(String name, String hakbun, int score)
	{
		this.name=name;
		this.hakbun=hakbun;
		this.score=score;
	}
	
	
	
}