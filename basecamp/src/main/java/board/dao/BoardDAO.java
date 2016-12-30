package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDAO {
	public int writePost(BoardVO vo) throws Exception;
	public int modPost(BoardVO vo) throws Exception;
	public BoardVO selectPost(String postId) throws Exception;
	public List<BoardVO> selectBoardList() throws Exception;
	public int checkPw(BoardVO vo) throws Exception;
}
