package test.day0714;

import java.util.Scanner;

public class Ex14Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		String msg;
		int []alpha=new int[26];	// 알파벳 26개
		
		System.out.println("영어 문장 입력");
		msg=sc.nextLine();
		
		// 문자열의 갯수만큼 반복
		for(int i=0;i<msg.length();i++) //받은 문자열의 갯수만큼이라서 alpha가 아닌 msg의 길이여야함
		{
			// 소문자로 변경후 한글자씩 추출
			char a=msg.toLowerCase().charAt(i);

			
//	================================ 여기까지만 오픈하고 결과값만 보여주심================================
			
			// 알파벳인 경우에만 갯수에 포함
			if(a>='a' && a<='z')
				alpha[a-'a']++;
				// a-a = 0 		0번째 배열을 증가시킨다
				// a-z = 25 	25번째 배열을 증가시킨다
		}
		
		for(int i=0;i<alpha.length;i++)
		{
			System.out.printf("%c:%d개\t",i+'A',alpha[i]); 
			if(i%5==4)
				System.out.println();		// 배열 0 1 2 3 4 까지 나오고 줄넘김
		}
//	================================ 여기까지 만들어야함 ================================
	}

}
