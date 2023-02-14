package test.day0725;

class Super5
{
	private String writer;	//멤버변수
	private String job;
	
	
	public Super5() {
		super();
	}

	public Super5(String writer) {
		super();
		this.writer = writer;
	}

	public Super5(String writer, String job) {
		super();
		this.writer = writer;
		this.job = job;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override		//부모는 toString에서 윗부분만 필요
	public String toString() {
		return "Super5 [writer=" + writer + ", job=" + job + "]";
	}
	
	
	
	
}

////////////////////////////////////

class Worker extends Super5
{
	private int age;	//멤버변수
	private String hp;
	
	public Worker() {
		super();
	}

	public Worker(String writer) {	//부모한테 이름받고, 본인꺼는 아무것도 안받고
		super(writer);
	}

	public Worker(String writer, String job, int age, String hp) {	//부모한테 두개넘기고 본인도 두개
		super(writer, job);
		this.age = age;
		this.hp = hp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	@Override	// 내꺼받고, 부모한테 toString있으니까 체크
	public String toString() {
		return "Worker [age=" + age + ", hp=" + hp + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
////////////////////////////////////
public class Ex5Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Worker []w=new Worker[4];
		w[0]=new Worker();	//부모에 디폴트 생성자 필요
		w[1]=new Worker("이영자");	// 이름만 전달하는 생성자 필요
		w[2]=new Worker("강호동","IT개발자",29,"010-111-2222");	// 두개 전달하는 생성자 필요
		w[3]=new Worker("유재석","개그맨",34,"010-222-3333");
		
		System.out.println("** 초기값 출력 **");
		
		for(Worker worker:w)
			System.out.println(worker);
		System.out.println("** 0번 데이터 변경 후 0번만 다시 출력 **");
		w[0].setWriter("홍길동");
		w[0].setJob("배우");
		w[0].setAge(26);
		w[0].setHp("010-3434-5656");
		
		System.out.println("0번 이름:"+w[0].getWriter());
		System.out.println("0번 직업:"+w[0].getJob());
		System.out.println("0번 나이:"+w[0].getAge());
		System.out.println("0번 핸드폰:"+w[0].getHp());
		
		
		
	}

}
