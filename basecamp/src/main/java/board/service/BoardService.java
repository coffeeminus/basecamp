package board.service;

import java.util.List;

import board.vo.BoardVO;

public interface BoardService {

	public BoardVO selectPost(BoardVO vo);
	public List<BoardVO> selectBoardList() throws Exception;
	public int writePost(BoardVO vo) throws Exception;
}
