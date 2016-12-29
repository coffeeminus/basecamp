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
	
	@RequestMapping(value="/writePostForm.do")
	public String writePostForm(){
		return "writePostForm";
	}
	
	@RequestMapping(value="/writePost.do")
	public ModelAndView writePost(BoardVO vo){
		//redirect to form page 
		ModelAndView mv = new ModelAndView("writePostForm");
		
		//add post to database, get the return value
		int ret;
		try {
			ret = boardService.writePost(vo);
			mv.addObject("ret", ret);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " writePost error");
		}		
		return mv;
	}
	
	@RequestMapping(value="/postDetail.do")
	public ModelAndView postDetail(String postId){
		//get post by postId
		ModelAndView mv = new ModelAndView("postDetail");
		
		BoardVO post;
		try {
			post = boardService.selectPost(postId);
			mv.addObject("post", post);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " postDetail error");
		}
		return mv;
	}
	
	@RequestMapping(value="/modPost.do")
	public ModelAndView modPost(BoardVO vo){
		//redirect to postDetail.jsp
		ModelAndView mv = new ModelAndView("postDetail");
		
		int ret;
		try {
			ret = boardService.modPost(vo);
			mv.addObject("ret",ret);
		} catch (Exception e) {
			System.out.println(e.getMessage() + " modPost error");
		}
		return mv;
	}
}
