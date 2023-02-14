package bit.data.service;

import java.util.List;
//import java.util.Map;

import bit.data.dto.MemberDto;

public interface MemberServiceInter {
	
	public int getTotalCount();
	public List<MemberDto> getAllMembers();
	public void insertMember(MemberDto dto);
	public int getSearchId(String id);
	
	// 로그인했을때 우측상단에 OO님
	public String getName(String id);
	
	//public int getIdPassCheck(Map<String, String> map);
	//map으로 해도되지만 또 컨트롤러에서 작업해줘야하므로 서비스에서 끝내기
	public int getIdPassCheck(String id, String pass);
	
	public MemberDto getDataById(String id);
	public MemberDto getDataByNum(int num);
	//public void updatePhoto(Map<String, Object> map);
	public void updatePhoto(int num, String photo);
	public void updateMember(MemberDto dto);
	public void deleteMember(int num);
}
