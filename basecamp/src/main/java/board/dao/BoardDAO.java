package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	public int writePost(BoardVO vo) throws Exception;
	public void modPost(BoardVO vo) throws Exception;
	public BoardVO selectPost(String postId) throws Exception;
	public List<BoardVO> selectBoardList() throws Exception;
}
