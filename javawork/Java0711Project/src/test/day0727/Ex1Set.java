package test.day0727;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set 인터페이스 : Set을 구현하는 클래스에는 HashSet, TreeSet
//Set 의 특징은 : 중복값★이 들어갈 수 없다
//HashSet : 비순차적
//TreeSet : 오름차순 정렬
public class Ex1Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set1=new HashSet<>();	// 기본 구조이며, new HasSet<String>(); .. String이 생략됨
		System.out.println("크기: "+set1.size());	// 0
		
		//데이터 넣기
		set1.add("apple");
		set1.add("orange");
		set1.add("apple");
		set1.add("orange");
		set1.add("kiwi");
		System.out.println("크기: "+set1.size());	// 3 : 중복값은 1번만 들어간다. (정확히는 덮어써진다)
		
		System.out.println("** 출력 1 **");
		for(String s:set1)
			System.out.println(s);	// HashSet 이므로 비순차적으로 출력됨
		
		
		System.out.println("** 출력 2  **");
		Iterator<String> iter=set1.iterator();
		while(iter.hasNext())	// hasNext 가 true 일 동안 반복
		{
			System.out.println(iter.next());
		}
		
		
		
	}

}
