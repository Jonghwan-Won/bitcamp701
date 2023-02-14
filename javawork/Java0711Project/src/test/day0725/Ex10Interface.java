package test.day0725;

interface Command
{
	public void process();
	
}
///////////////////////////////
class List implements Command
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 조회한다");
	}
	
}

///////////////////////////////
class Insert implements Command
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 추가한다");
	}

}

///////////////////////////////
class Update implements Command
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 수정한다");
	}

}

///////////////////////////////
class Delete implements Command
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("데이터를 삭제한다");
	}

}

///////////////////////////////

public class Ex10Interface {
		
	public static void dbprocess(Command comm)	
	{
		//comm 에 어떤 클래스가 생성되어있느냐에 따라 
		//하는일이 달라진다
		comm.process();
	}
	
	public static void main(String[] args) {	//static 이니까 바로 호출 가능
		// TODO Auto-generated method stub
		dbprocess(new Insert());
		dbprocess(new Update());
		dbprocess(new Delete());
		dbprocess(new List());
	}

}

//교재 259페이지 다형성에 대한 설명
//교재 259페이지 예제

//교재 322~325페이지 예제