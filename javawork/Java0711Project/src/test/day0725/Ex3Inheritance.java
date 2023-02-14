package test.day0725;

class Super3
{
	private String schoolName;
	private String schoolLoc;

	Super3()
	{
		schoolName="청담중학교";
		schoolLoc="청담동";
	}

	Super3(String schoolName, String schoolLoc)
	{
		this.schoolName=schoolName;
		this.schoolLoc=schoolLoc;
	}

	@Override
	public String toString() {
		return "학교명:"+schoolName+",위치:"+schoolLoc;
	}

}

///////////////////////////////////////////////
class Student extends Super3
{
	private String stuName;

	Student(String stuName)
	{
		this.stuName=stuName;
	}

	Student(String schoolName,String schoolLoc,String stuName)
	{
		super(schoolName,schoolLoc);
		this.stuName=stuName;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String data=super.toString();	//부모클래스의 메서드
		data+="\n학생명:"+stuName;
		return data;
	}

}


	public class Ex3Inheritance {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Student s1=new Student("김영자");
			System.out.println(s1.toString());
			System.out.println(s1);		//레퍼런스변수만 쓸경우 자동으로 toString 호출
			
			Student s2=new Student("서초중학교","서초동","박나래");
			System.out.println(s2);
		}

	}
	
