package test.day0725;
//interface끼리의 상속도 가능하다
//interface상속은 class상속과 마찬가지로 extends
interface InterB
{
	public void study();
}

interface InterC extends InterB
{
	public void play();
}

class MyA implements InterB
{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}
	
}

class MyB implements InterC
{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Ex9Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
