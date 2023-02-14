package test.day0726;

import java.util.Scanner;

public class Ex1Interface {
	//Dao가 가진 interface를 호출해야함
	DaoInter dao=new MemberDao();	// 구현한 클래스를 생성
	Scanner sc=new Scanner(System.in);
	
	public void  process()
	{
		//main에서 해당 process를 호출하기위해선 main쪽에 작업이 필요
		// Ex1Interface ex=new Ex1Interface();
		// ex.process();
		
		while(true)
		{
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
			int num=Integer.parseInt(sc.nextLine());
			switch(num)
			{
			case 1:	
			{	//구역 설정
				System.out.println("추가할 이름과 주소 입력");
				String name=sc.nextLine();
				String addr=sc.nextLine();
				//dto 생성
				MemberDto dto=new MemberDto(name, addr);	//생성자를 통해 dto로 전달
				//dao에 insert
				dao.insertMember(dto);
				break;
			}
			
			case 2:	
			{	//구역 설정
				System.out.println("수정할 이름과 새로운 주소 입력");
				String name=sc.nextLine();
				String addr=sc.nextLine();
				//dto 생성
				MemberDto dto=new MemberDto(name, addr);
				//dao에 update
				dao.updateMember(dto);
				break;
			}
			
			case 3:
			{
				System.out.println("삭제할 이름 입력하기");
				String name=sc.nextLine();
				dao.deleteMember(name);
				break;
			}
			
			case 4:
				dao.selectAll();
				break;
				
				
			default:	//case 5:	5가아닌 값들을 입력하더라도 종료되도록 default로 
				System.out.println("종료합니다");
				System.exit(0);	//break; 써도 종료되지만	해당 메서드 자체가 종료시에는 0을 보내도록 되어있음
				
			}//switch
			
		}//while
			
	}//method
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1Interface ex=new Ex1Interface();
		ex.process();
	}

}
