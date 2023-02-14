package ex2;

public class Student {

	//객체 자체를 주입받는 클래스로 진행
	
	String schoolName;
	MyInfo myInfo;
	
	public Student(MyInfo myInfo) {	//Student라는 생성자에 myInfo 레퍼런스 주입
		this.myInfo=myInfo;
	}
	
	public void setSchoolName(String schoolName) {	//setter주입
		this.schoolName = schoolName;
	}
	
	public void show()	//제대로 주입되었나 확인하기 위함
	{
		System.out.println(myInfo.toString());
		System.out.println("학교:"+schoolName);
	}
}
