package test.day0726;

// 아래가 DTO의 기본 구조

public class MemberDto {
	//변수 두개 생성
	private String name;
	private String addr;

	
	//우클릭 > source > ...using field > 두개 선택
	public MemberDto() {
		super();	// 지워도 상관없음
	}
	
	//우클릭 > source > ...using field > 두개 선택
	public MemberDto(String name, String addr) {
		super();
		this.name = name;
		this.addr = addr;
	}

	//우클릭 > source > getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
	
	
	
}
