package test.day0726;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Ex10Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//BufferedReader 의 readLine() = scanner 의 nextLine() 과 비슷함
		
		FileReader fr=null;
		BufferedReader br=null;

		//fr을 생성하는 코드
		try {
			fr=new FileReader("C:\\java0711\\javawork\\Java0711Project\\src\\test\\day0726\\Ex3Anony.java");
			br=new BufferedReader(fr);	//fr 관련 먼저 작성하고 나중에 br 진행함
			
			//앞에 라인번호도 출력해보자	//fr, br 파트 작성 후 진행
			int n=0;
			while(true)
			{
				//한줄씩 읽기
				String line=br.readLine(); //add catch : 기존 catch에 추가

				//마지막 문장까지 읽으면 null 값을 반환한다
				if(line==null)
					break;
				
				//읽은 line을 행번호와 함께 출력해보자
				System.out.println(++n+":"+line);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// exception이 발생해야만 실행되는 영역
//			e.printStackTrace();
			System.out.println("파일이 없어요 : "+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	// finally : exception과 상관없이 무조건 실행되는 영역
			try {
				br.close(); //나중에 생성한 자원을 먼저 닫는다
				fr.close(); //여기서 exception 발생 > 오류 발생 > try/catch 생성
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
