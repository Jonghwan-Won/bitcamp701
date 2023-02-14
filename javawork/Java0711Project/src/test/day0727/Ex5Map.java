package test.day0727;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map 인터페이스 : Map인터페이스를 구현한 대표적인 클래스 HashMap
//key, value의 쌍으로 저장되는 구조
//이때 key의 타입은 set타입이다. 즉, 중복되지않고 비순차적

public class Ex5Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> map1=new HashMap<>();	//key와 value를 String 타입으로 지정
		System.out.println(map1.size());			//생성하자마자 출력하면 값은 0
		
		map1.put("name", "김태희");	// name이라는 key에 김태희라는 value 지정
		map1.put("age", "23세");
		map1.put("addr", "강남구");
		map1.put("name", "이효리");	// key 값은 set이므로 중복값이 덮어써짐
		
		System.out.println(map1.size());	// 3 : 3개의 데이터(key 와 value)를 넣었으므로
		
		System.out.println("이름 :"+map1.get("name"));	// 이효리
		System.out.println("나이 :"+map1.get("age"));
		System.out.println("주소 :"+map1.get("addr"));
		System.out.println("혈액형 :"+map1.get("blood"));	// 해당 key가 없을 경우 null
		
		System.out.println("** 전체 key 와 value를 알고싶을때 **");
		
		//key값들을 먼저 얻는다
		Set<String> keys=map1.keySet();	// .keySet() 함수는 key를 가져오는 함수 -> keys에 문자열로 가져오겠다
		for(String k:keys)	// 가져온 문자열을 갯수만큼 반복하여 String변수 k에 넣는다
		{
			String v=map1.get(k);	//k 키에 들어있는 값을 v에 넣는다
			System.out.println(k+" => "+v);
					
		}
		
		
	}

}
