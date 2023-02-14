package test.day0726;

import java.util.List;
import java.util.Vector;

public class MemberDao implements DaoInter {	//DaoInter를 구현하겠다
	//클래스 생성할 때 interface 부분에 add하면 자동으로 override됨
	
	List<MemberDto>	list=new Vector<>();
	//<>:제네릭스:List에 MemberDto 만 담겠다
	//배열을 써도 되지만 
	
	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		System.out.println(dto.getName()+"님을 리스트에 추가함!");
		list.add(dto);	//리스트에 추가	(List는 인터페이스..Vector가 가진 override한 add)
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub

		//dto의 이름이 어디에 있는지 인덱스 알아내기 (list.set을 사용하기위한 사전 작업)
		int idx=-1;
		for(int i=0;i<list.size();i++)	//배열로 치면 length와 같음 (list.size)
		{
			if(dto.getName().equals(list.get(i).getName())) {
				idx=i;
				break;
			}
		}
		
		if(idx==-1)
			System.out.println("수정할 이름의 멤버가 없습니다!");
		else
		{
			list.set(idx, dto);	//index번지를 dto로 수정(set)한다
			System.out.println("수정했습니다.");
		}
	}

	@Override
	public void deleteMember(String name) {
		// TODO Auto-generated method stub
		int idx=-1; //검색 시 없을 수 있으니까 -1로 주기
		for(int i=0;i<list.size();i++)
		{
			//get(i)로 꺼낼경우 memberDto 타입이 된다
			MemberDto dto=list.get(i);
			if(name.equals(dto.getName()))	//String name 이므로  name에서 찾아야함(update에서는 dto.으로 진행했음)
			{
				idx=i;
				break;
			}
			
		}
		if(idx==-1)
			System.out.println(name+"님은 명단에 없습니다");
		else
		{
			System.out.println(name+"님의 정보를 삭제했습니다");
			list.remove(idx);	//삭제
		}
		
	}

	@Override
	public void selectAll() {
		// TODO Auto-generated method stub
		System.out.println("총 "+list.size()+"명");
		System.out.println("이름\t주소");
		for(MemberDto dto:list)
			System.out.println(dto.getName()+"\t"+dto.getAddr());	//name을 직접 못가져옴..private 이라서..
		
			
	}
	
	
	
	

}
