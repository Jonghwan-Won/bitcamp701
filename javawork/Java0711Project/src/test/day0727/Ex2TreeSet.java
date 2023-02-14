package test.day0727;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex2TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set1=new TreeSet<>();
		set1.add("apple");
		set1.add("manggo");
		set1.add("banana");
		set1.add("apple");
		set1.add("orange");
		System.out.println(set1.size());	// 4 : 중복 제외
		
		System.out.println("** 출력 **");
		for(String s:set1)
			System.out.println(s);	// 오름차순으로 출력됨
		
		System.out.println();
		
		System.out.println("** 로또 숫자 6개를 구하시오 **");
		Random r=new Random();	// 난수 생성을 위해 Random 메서드 선언 및 import
		
		Set<Integer> lotto=new TreeSet<>();	// TreeSet 컬렉션을 사용하기 위한 선언
		
		while(true)	// 반복횟수를 정하지 않고 반복
		{	
			int n=r.nextInt(45)+1;	// 정수형 변수 n을 선언하고 r에서 발생한 난수를 담는다 (0부터 45구하고 +1)
			lotto.add(n);			// lotto TreeSet에 생성된 난수 n을 담는다	
			
			if(lotto.size()==6)		// lotto TreeSet의 사이즈가 6개가 되면 더 반복하지않고 빠져나간다
			{
				break;
			}
				
		}
		
		for(int n:lotto)			// lotto TreeSet을 정수형 n에 담아서 반복 출력한다
			System.out.print(n+" ");
		
		
		
		
	}

}
