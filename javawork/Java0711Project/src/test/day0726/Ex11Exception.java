package test.day0726;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// C:\java0711\score.txt 를 읽은 후 갯수, 총점, 평균을 구하시오


		FileReader fr = null;	// 1.
		BufferedReader br = null; // 5.

		try {
			fr=new FileReader("C:\\java0711\\score.txt");	// 2. 해당 경로의 파일을 읽는다 -> 에러 발생
			br=new BufferedReader(fr);	// 5. 

			// 8. try 안에 메모장 파일을 한줄씩 읽어와서 갯수, 총점, 평균 구하기 진행
			int cnt=0;
			int sum=0;
			double avg;

			while(true)
			{
				String line=br.readLine();	// 9. 한줄씩 읽어오기 > 오류 > 기존 catch에 추가

				// 10. 마지막까지 읽으면 null 값 반환 -> score.txt의 마지막줄은 빈칸임 null
				if(line==null)
					break;

				// 11. 갯수 증가
				cnt++;

				// 12. 총점 구하기 // sum+=Integer.parseInt(line);

				// 심화-> score.txt 파일에 57a 와 같은 문자가 섞일 경우
				// Exception이 발생하는 위치에 수기로 try catch 작성

				try {
					sum+=Integer.parseInt(line);	// 오류 발생부분 무시하고 sum 값 구하기
				} catch(NumberFormatException e) {
					cnt--;	// 오류가 발생하는 부분은 11. 에서 cnt 증가했던거 다시 감소
				}

			}

			// 13. 평균 구하기
			avg=(double)sum/cnt;

			// 14. line에서 구한 갯수와 총점, 평균 출력
			System.out.println("총 : "+cnt+"개");
			System.out.println("총 점 : "+sum);
			System.out.printf("평 균 : %5.2f",avg);



		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// FileNotFoundException이 발생해야만 실행되는 영역임
			//			e.printStackTrace();	// 6. 이거 주석처리하고
			System.out.println("파일이 없습니다! : "+e.getMessage());	// 7. 파일을 찾을 수 없을때 발생하는 메시지 발생시키기

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {	// 3. catch 뒤에 finally {fr.close} 작성 : exception과 상관없이 무조건 실행되는 영역 > 4. try/catch
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




	}

}
