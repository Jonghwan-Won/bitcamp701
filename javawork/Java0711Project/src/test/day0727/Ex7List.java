package test.day0727;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Ex7List {

	//멤버 변수로 선언해두기
	List<Person> list=new Vector<>();	// Person.java
	Scanner sc=new Scanner(System.in);
	
	//멤버 변수 호출 방법
    //클래스명 변수 = new 클래스명();

	//저장할 파일경로
	static final String FILENAME="C:\\java0711\\person.txt";
	
	

	
	/////////////////////////////////////////////////////////////////
	
	public Ex7List() {
		// TODO Auto-generated constructor stub
		this.fileRead();	//처음 실행시 파일 읽어오기
	}
	
	//데이터 추가하는 메서드
	public void addPerson()	//나중에 생성할거라서 파라미터는 없어도됨
	{
		System.out.println("person 데이터를 추가합니다");
		System.out.println("추가할 이름은?");
		String name=sc.nextLine();
		// 같은 이름이 있을 경우 "이미 존재하는 이름입니다" 출력 후 메서드 종료 : return;
		
		
		//해당 name이 있는곳의 인덱스 얻기
		int idx=this.getSearchName(name);
		if(idx>=0)
		{
			System.out.println("이미 존재하는 이름입니다");
			return;

		}
		
		
		
		System.out.println("추가할 나이는?");
		String age=sc.nextLine();
		System.out.println("추가할 주소는?");
		String addr=sc.nextLine();
		
		
		
		//Person 생성
		
//		Person p=new Person(name, age, addr);	// class Person	// 방법 1 : 생성자 활용
		Person p=new Person();	// 방법2 : 디폴트로 생성하고 후 작업
		p.setName(name);
		p.setAge(age);
		p.setAddr(addr);
		
		//list에 추가
		list.add(p);
	}
	
	//전체 데이터 출력하는 메서드
	public void writePerson()
	{
		System.out.println("person 전체 데이터를 출력합니다");
		System.out.println("총 "+list.size()+"명");
		System.out.println();
		System.out.println("번호	이름	나이	주소");
		
		for(int i=0;i<list.size();i++)
		{
			//i번째 person
			Person p=list.get(i);
			System.out.println(i+1+"\t"+p.getName()+"\t"+p.getAge()+"\t"+p.getAddr());
		}
	}
	
	//메뉴 입력 후 번호 반환하는 메서드
	public int getMenu()
	{
		System.out.println("** 메뉴 **");
		System.out.println("1. 추가");
		System.out.println("2. 전체 출력");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 저장 후 종료");
		System.out.println("---------------");
		
		
		int n=0;
		
		try {
			n=Integer.parseInt(sc.nextLine());
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("** 문자입력 : 전체 출력합니다 **");		//1~5 외에 문자를 입력받으면 2. 전체 출력 되도록 설정
			n=2;
		}
		
//		return 0;
		return n;

	}
	
	//이름을 입력하면 해당 데이터가 있는 곳의 인덱스 반환
	//만약 없다면 -1을 반환
	public int getSearchName(String name)	//파라미터를 받는것으로 설정
	{
		int idx=-1;
		for(int i=0;i<list.size();i++)
		{
			//i번째 데이터 얻기
			Person p=list.get(i);
			
			//이름 비교해서 같으면 idx에 i 값 저장 후 빠져나가기
			if(p.getName().equals(name)) {
				idx=i;
				break;
			}
		}
		return idx;		//int idx=-1; 이므로 searchPerson에서 없는 이름을 검색하면 -1 리턴
	}
	
	//이름 입력하면 해당 데이터만 나오게 하기
	public void searchPerson()	// 입력받을거라서 파라미터 없이
	{
		System.out.println("이름으로 검색하기");
		System.out.println("조회할 이름은?");
		String name=sc.nextLine();
		
		//해당 name이 있는곳의 인덱스 얻기
		int idx=this.getSearchName(name);
		if(idx==-1)
		{
			System.out.println(name+"님은 명단에 없습니다");
			
		}
		else
		{
			//해당 인덱스 번지에서 데이터를 꺼낸다
			Person p=list.get(idx);
			System.out.println("** 조회 결과 **");
			System.out.println("이 름 : "+p.getName());
			System.out.println("나 이 : "+p.getAge());
			System.out.println("주 소 : "+p.getAddr());
		}
	}
	
	//이름 입력하면 해당 데이터 찾아서 지우기
	public void deletePerson()
	{
		System.out.println("이름으로 찾아서 삭제하기");
		System.out.println("삭제할 이름은?");
		String name=sc.nextLine();
		
		//해당 name이 있는곳의 인덱스 얻기
		int idx=this.getSearchName(name);
		
		if(idx==-1)
		{
			System.out.println(name+"님은 명단에 없습니다");
			
		}
		else
		{
			//해당 인덱스 번지에서 데이터를 삭제한다
			list.remove(idx);
			
			System.out.println("삭제되었습니다");
		}
	}
	
	
	
	
	//처음 시작시 파일에서 읽어서 list에 담기
	//생성자에 넣으면 시작하자마자 읽을 수 있음, 자바스크립트의 windows onload와 유사
	public void fileRead()
	{
//		System.out.println("파일을 읽어옵니다");

		FileReader fr=null;	//try catch 할거라서 null값 부여
		BufferedReader br=null;
		
		try {
			fr=new FileReader(FILENAME);		// 1. 오류 발생으로 인한 try catch
			br=new BufferedReader(fr);			// 3. br 추가
			
			// 한줄 단위로 읽어서, (콤마)로 분리하고 person에 넣은 후 list에 추가
			while(true)
			{
				String line=br.readLine();		// 5. 한줄단위로 읽기 : 오류발생 > add catch

				// 6. 더이상 읽을 데이터가 없으면 종료
				if(line==null)
					break;

////////////////////////////////////////////////////////////////
//				// 7. ,(콤마) 로 분리된 데이터를 배열로 읽어오기
//				String []data=line.split(",");
//				
//				
//				// 8. Person 객체 생성 : 디폴트로하고 setter 활용
//				Person p=new Person();
//				p.setName(data[0]);
//				p.setAge(data[1]);
//				p.setAddr(data[2]);
				
				// ,(콤마)로 분리하는 방법 #2
				// split으로 분리안되는 문자가 가끔있는데, 이 방법으로는 다 됨
				Person p=new Person();
				StringTokenizer st=new StringTokenizer(line, ",");
				p.setName(st.nextToken());
				p.setAge(st.nextToken());
				p.setAddr(st.nextToken());
				
				
				// 9. 리스트에 추가
				list.add(p);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("저장된 데이터가 없습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	// 2. 닫기위한 finally 와 fr.close() 작성 후 try catch
			try {	
				br.close();						// 4. br.close() 추가 -> 닫을때는 br먼저
				fr.close();
			} catch (IOException | NullPointerException e2) {	// 5. or 연산자 활용해서 NullPointerException 방지
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("파일읽기 오류 발생:"+e2.getMessage());
			}
		}
		
		
	}
	
	//종료시 전체 데이터을 파일에 저장하는 메서드 : 종료할 떄 호출
	public void fileWrite()
	{
		System.out.println("list를 저장 후 종료합니다");
		
		FileWriter fw=null;					// 1. try, catch
		try {
			fw=new FileWriter(FILENAME);
			// 3. 이름,나이,주소 -> 형태로 저장하기
			for(Person p:list)
			{
				String s=p.getName()+","+p.getAge()+","+p.getAddr()+"\n";
				fw.write(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {							// 2. 닫아주는 finally > fw.close() 작성해주고 다시 try catch
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	/////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex7List ex=new Ex7List();
		while(true)
		{
			switch(ex.getMenu())
			{
			case 1:	//추가
				ex.addPerson(); break;
			case 2:	//전체 출력
				ex.writePerson(); break;
			case 3:	//검색
				ex.searchPerson(); break;
			case 4:	//삭제
				ex.deletePerson(); break;
			default:
				ex.fileWrite();
				System.exit(0);
				
			}
			System.out.println();
		}
	}

}
