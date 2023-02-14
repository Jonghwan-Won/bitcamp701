package test.day0718;

import test.day0715.Student;

public class Ex5Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Student 클래스 배열 생성
		Student [] sarr = {
				new Student(),
				new Student("캔디", 90, 80, 70),
				new Student("마이클", 100, 89, 67),
				new Student("캐서린", 100, 100, 70)
				
		};
		
		System.out.println("총 "+sarr.length+"명");
		System.out.println("** 출력 **");
		for(int i=0;i<sarr.length;i++)
			sarr[i].write();
		
		
	}

}
