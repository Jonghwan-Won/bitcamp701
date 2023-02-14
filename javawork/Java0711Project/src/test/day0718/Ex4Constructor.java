package test.day0718;

import test.day0715.Student;	// test.day0715 패키지에 Student.java

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student stu1=new Student();				
//		Student stu2=new Student("이미자", 90, 89, 100);
//		Student stu3=new Student("강호동", 90, 89, 78);
//		stu1.write();
//		stu2.write();
//		stu3.write();
		
		// 배열로 생성 후 출력을 해보자
		Student[] sarr=new Student[3];	// 생성자 호출이 아님
		// 배열 갯수만큼 생성자 호출
		sarr[0]=new Student();
		sarr[1]=new Student("이미자", 90, 89, 100);
		sarr[2]=new Student("강호동", 90, 89, 78);
		
		System.out.println("출력 #1");
		for(int i=0;i<sarr.length;i++)
			sarr[i].write();
		
		
		System.out.println("출력 #2");
		for(Student s:sarr)	
			s.write();
			
		
		
	}

}




