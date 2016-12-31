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

	/*
	 * 게시물을 등록하는 메소드
	 */
	@Override
	public int writePost(BoardVO vo) throws Exception {
		return sqlSession.insert("board.writePost", vo);
		
	}

	/*
	 * 게시물을 수정하는 메소드
	 */
	@Override
	public int modPost(BoardVO vo) throws Exception {
		return sqlSession.update("board.modPost", vo);		
	}

	/*
	 * 선택된 게시물의 정보를 가져옴
	 */
	@Override
	public BoardVO selectPost(String postId) throws Exception {		
		return sqlSession.selectOne("board.selectPost", postId);
	}

	/*
	 * 전체 게시물을 가져오는 메소드 
	 */
	@Override
	public List<BoardVO> selectBoardList() throws Exception {		
		return sqlSession.selectList("board.selectBoardList");
	}
	/*
	 * 글 수정시 비밀번호를 확인하는 메소드
	 * @return 매치가 없을때 0, 있을때 1
	 */
	@Override
	public int checkPw(BoardVO vo) throws Exception {
		int ret = sqlSession.selectOne("board.checkPw", vo);
		return ret;
	}
}
