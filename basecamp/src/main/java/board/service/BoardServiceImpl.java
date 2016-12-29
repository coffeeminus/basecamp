package board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import board.dao.BoardDAO;
import board.vo.BoardVO;

@Component
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO; 
	
	/*
	 * 선택된 게시물의 상세페이지를 위해 구현한 메소드
	 * @return BoardVO 해당하는 게시판 내용 리턴
	 */
	@Override
	public BoardVO selectPost(String postId) throws Exception{
		return boardDAO.selectPost(postId); 
	}
	/*
	 * 게시판 전체 글들을 불러오는 메소드
	 */
	@Override
	public List<BoardVO> selectBoardList() throws Exception{		
		return boardDAO.selectBoardList();
	}
	/*
	 * 게시물을 등록하는 메소드
	 */
	@Override
	public int writePost(BoardVO vo) throws Exception {
		return boardDAO.writePost(vo);
	} 
}
