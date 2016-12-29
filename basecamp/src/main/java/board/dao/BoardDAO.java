package board.dao;

import java.util.List;

import board.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	public void writePost(BoardVO vo) throws Exception;
	public void modPost(BoardVO vo) throws Exception;
	public BoardVO selectPost(BoardVO vo) throws Exception;
}
