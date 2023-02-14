package test.day0726;

import java.io.FileWriter;
import java.io.IOException;

public class Ex9Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;	// 해당 경로에 파일쓰기
		try 
		{
			fw=new FileWriter("c:/java0711/memo.txt");	// 경로는 슬래시, 역슬래시 둘 다 가능한데, 역슬래시는 두번씩 해야됨\\
			fw.write("이름:홍길동\n");
			fw.write("주소:비트캠프\n");
			
			System.out.println("파일을 확인하세요");
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try 
			{
				fw.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
