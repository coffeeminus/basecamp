package board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.vo.BoardVO;

/**
 * BoardDAO 구현 클래스
 */
@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writePost(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modPost(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 선택된 게시물의 정보를 가져옴
	 */
	@Override
	public BoardVO selectPost(BoardVO vo) throws Exception {		
		return sqlSession.selectOne("board.selectPost", vo);
	}	
}
