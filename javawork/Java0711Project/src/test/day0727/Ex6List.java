package test.day0727;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex6List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list1=new Vector<>();		//초기할당크기 : 10	-> 초과되면 20개로 늘어남
		Vector<String> list2=new Vector<>(5);	//초기할당크기 : 5	-> 초과되면 10개로 늘어남
		List<String> list3=new Vector<>(3,2);	//초기할당크기 : 3, 초과되면 2개씩 늘어남
		
		System.out.println(list1.size());		//데이터 개수 확인
		System.out.println(list2.size());		//데이터 개수 확인
		System.out.println(list3.size());		//데이터 개수 확인
		
		System.out.println("** 초기 할당 크기(용량) 확인 **");
		System.out.println(((Vector)list1).capacity());	// 다운 캐스팅 (자식 타입으로 변경 : Vector)
		System.out.println(list2.capacity());			// 이미 Vector로 선언되었으므로 capacity 사용 가능
		System.out.println(((Vector)list3).capacity());	// 다운 캐스팅
		
		// size() 메서드를 사용하면 Vector 데이터의 개수를 구합니다
		// capacity() 메서드를 사용하면 Vector의 용량을 구합니다
		
		
		
		
		///////////////////////////////////////////////////

		
		// list1에 데이터 삽입
		list1.add("사과");
		list1.add("오렌지");
		list1.add("사과");
		list1.add("딸기");
		list1.add("수박");
		
		// list2에 데이터 삽입
		String []s= {"red","green","pink","yellow","orange","gray"};
		for(String s1:s)
			list2.add(s1);
		
		// list3에 데이터 삽입
		list3=Arrays.asList("이영자","이순실","강호동","차혜련");
		
		
		// list1 ~ list3 각각 데이터 삽입 후 용량 재확인
		System.out.println("데이터 추가 후 할당 크기 다시 확인하기");
		System.out.println(((Vector)list1).capacity());	
		System.out.println(list2.capacity());			// 5개였는데, 초과된 6개를 넣어서 할당크기가 10으로 증가됨
//		System.out.println(((Vector)list3).capacity());	// 오류나서 주석처리함
		
		
		//////////////////////////////////////////////////////////////

		System.out.println("출력 #1");
		for(String s1:list1)			// 배열 갯수만큼 자동으로 반복
			System.out.println(s1);		// 중복값도 그대로 출력됨
		
		
		
		// .get 메서드로 가져와서 Sting 변수에 넣어 출력
		System.out.println("출력 #2");
		for(int i=0;i<list2.size();i++)
		{
			String s2=list2.get(i);
			System.out.println(s2);
					
		}
		
		
		// Vector 출력 - Iterator
		System.out.println("출력 #3");
		Iterator<String> iter=list3.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
			
		
	}

}
