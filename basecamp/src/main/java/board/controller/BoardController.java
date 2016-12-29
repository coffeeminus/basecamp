package board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.service.BoardService;
import board.vo.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/openPost.do")
	public ModelAndView openPost(BoardVO vo){
		ModelAndView mv = new ModelAndView("/board/openPost");
		
		//get text from db using email from prev page
		BoardVO post = boardService.selectPost(vo);
		
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value="/boardList.do")
	public ModelAndView boardList(){
		ModelAndView mv = new ModelAndView("boardList");
		
		List<BoardVO> list;
		try {
			list = boardService.selectBoardList();
			mv.addObject("list",list);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " boardList error");
		}		
		return mv;
	}	
}
