package bit.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.data.dao.BoardDaoInter;
import bit.data.dto.BoardDto;

@Service
public class BoardService implements BoardServiceInter {

	
	@Autowired	//기본 초기값은 null 이므로 @autowired 붙이기
	
	//dao의 메서드를 호출해야함 (인터페이스 또는 클래스로 선언)
	BoardDaoInter boardDao;
	
	
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return boardDao.getMaxNum();
	}

	@Override
	public int getTotalCount(String searchcolumn, String searchword) {
		// TODO Auto-generated method stub
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("searchcolumn", searchcolumn);	//반드시 mapper 와 일치시킬것
		map.put("searchword", searchword);
		
		return boardDao.getTotalCount(map);
	}

	@Override
	public List<BoardDto> getPagingList(String searchcolumn, String searchword, int startnum, int perpage) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("searchcolumn", searchcolumn);	//반드시 mapper 와 일치시킬것
		map.put("searchword", searchword);
		map.put("startnum", startnum);
		map.put("perpage", perpage);
		
		return boardDao.getPagingList(map);
	}

	@Override
	public void insertBoard(BoardDto dto) {
		// TODO Auto-generated method stub
		
		//새글인지 답글인지 판단해서 로직 작성
		int num=dto.getNum();	//새 글일때 0이 들어가있다
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) {	//새 글일때
			regroup=this.getMaxNum()+1;	//겹치지않게하기위함
			restep=0;
			relevel=0;
			
		}else {	//답글일때
			
			//같은 그룹 중 전달받은 restep보다 큰 값들은 모두 일괄적으로 +1을 해준다
			this.updateRestep(regroup, restep);
			
			//전달받은 값보다 1크게 db에 저장한다
			restep++;
			relevel++;
		}
		
		//변경된 값들을 다시 dto에 넣는다
		dto.setRegroup(regroup);	//새글이면 maxnum+1로 들어갈거고, 답글이면 전달받은 regroup 값 그대로 가짐
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		boardDao.insertBoard(dto);
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub

		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("regroup", regroup);	//반드시 mapper 와 일치시킬것
		map.put("restep", restep);
		
		boardDao.updateRestep(map);
	}

	@Override
	public void updateReadCount(int num) {
		// TODO Auto-generated method stub

		boardDao.updateReadCount(num);
	}

	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		
		return boardDao.getData(num);
	}

	@Override
	public void updateBoard(BoardDto dto) {
		// TODO Auto-generated method stub

		boardDao.updateBoard(dto);
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub

		boardDao.deleteBoard(num);
	}

	@Override
	public void likesUpdate(int num) {
		// TODO Auto-generated method stub

		boardDao.likesUpdate(num);
	}

}
