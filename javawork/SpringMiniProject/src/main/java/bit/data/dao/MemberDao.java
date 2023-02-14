package bit.data.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.data.dto.MemberDto;

@Repository
public class MemberDao implements MemberDaoInter {
	
	@Autowired	//xml 세팅이 잘되어있다면 자동으로 주입됨
	SqlSession session;	//root-context에 있음
	String ns="bit.data.dao.MemberDao.";	//mapper의 sql을 사용할건데 name space가 너무길어서 줄이기위함
	

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		
		//원래는 앞에 namespace.id 인데, 생략 가능(다른 파일에 같은 id가 있을 수 있으므로 붙이는게 좋음
		//ex. 다른 Dao에도 getTotalCount가 있으면 오류남
		return session.selectOne(ns+"getTotalCount");
	}

	@Override
	public List<MemberDto> getAllMembers() {
		// TODO Auto-generated method stub
		
		return session.selectList(ns+"getAllMembers");
	}

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub

		session.insert(ns+"insertMember", dto);
	}

	@Override
	public int getSearchId(String id) {
		// TODO Auto-generated method stub
		
		return session.selectOne(ns+"getIdSearch", id);
		//mapper 에 있는 sql이랑 값이 꼭 같아야함 #{id}
	}

	@Override
	public String getName(String id) {
		// TODO Auto-generated method stub
		
		return session.selectOne(ns+"getName", id);	//Mapper와 반드시 일치시킬것
	}

	@Override
	public int getIdPassCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		return session.selectOne(ns+"loginIdPassCheck",map);
	}

	@Override
	public MemberDto getDataById(String id) {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"getDataById",id);
	}

	@Override
	public MemberDto getDataByNum(int num) {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"getDataByNum", num);
	}

	@Override
	public void updatePhoto(Map<String, Object> map) {
		// TODO Auto-generated method stub
		session.update(ns+"updatePhoto", map);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.update(ns+"updateMember",dto);
	}

	@Override
	public void deleteMember(int num) {
		// TODO Auto-generated method stub
		session.delete(ns+"deleteMember", num);
	}

	
	
	
}
