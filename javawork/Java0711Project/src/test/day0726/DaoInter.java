package test.day0726;

public interface DaoInter {	//new > class 가 아닌 interface 로 생성
	
	public void insertMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(String name);
	public void selectAll();
	
	
}
