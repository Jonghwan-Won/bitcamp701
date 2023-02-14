package test.day0714;

import java.util.Scanner;

public class Ex8Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] names= {"이영자","강호동","유재석","강소라","이진","이효리","우영우","우지원","유민","박나래"};
		String searchName;
		boolean flag=false;
		
		Scanner sc=new Scanner(System.in);
		
		// 이름을 입력하면 "2번째에 있습니다"
		// 없을경우 "없습니다"

		System.out.println("이름을 입력하세요");
		searchName=sc.nextLine();
		
		for(int i=0;i<names.length;i++) {
			if(searchName.equals(names[i]))		//String 문자열 타입은 == 사용이 불가하므로 equals or equalsIgnorecase를 사용해야함
//			if(searchName.equals(names[i]==ture))  <- true까지 써야하는데,없을땐 생략되므로 상관없음
			{
				flag=true;
				System.out.println(i+1+"번째에 있습니다");
				break; //  break; 가 없어도 결과는 같음, 만약 동명이인이 있으면 또 출력될거임
			}
			
		}
		if(!flag)
			System.out.println("없습니다");
		
	}

}

// 검색 : 순차검색(순서 상관없이 검색 // 데이터가 많으면 속도가 느림)
//		  이분검색(정렬이 되어있어야함 // 검색 속도가 빠름 // 알고리즘활용으로 난이도가 높음)

