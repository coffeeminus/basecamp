package board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import board.dao.BoardDAO;
import board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO; 
	/*
	 * 선택된 게시물의 상세페이지를 위해 구현한 메소드
	 * @return BoardVO 해당하는 게시판 내용 리턴
	 */
	@Override
	public BoardVO selectPost(BoardVO vo){
		//return boardDAO.selectPost(vo);
		return null;
	}
 
}
