package toast.basecamp.board;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import board.dao.BoardDAO;
import board.vo.BoardVO;
import junit.framework.Assert;

/**
 * 이메일, 비밀번호, 본문 등록 테스트하는 클래스
 * @author yeji
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/config/action-servlet.xml",
		"file:src/main/resources/config/spring/context-datasource.xml",
		"file:src/main/resources/config/spring/context-mapper.xml"})
public class WritePostTest {
	
	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Test
	public void testWritePost() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setEmail("hello_nhn@naver.com");
		vo.setPw("0000");
		vo.setText("junit test~");
		
		//테스트용 자료 저장
		boardDAO.writePost(vo);
			
		//제일 첫번째자료가 방금 저장한 자료여야 함 
		List<BoardVO> list = boardDAO.selectBoardList();
			
		//첫번째 자료를 뽑기
		BoardVO newPost = list.get(0);
			
		//같은 자료인지 확인하기
		Assert.assertEquals(vo.getEmail(), newPost.getEmail());
		Assert.assertEquals(vo.getPw(), newPost.getPw());
		Assert.assertEquals(vo.getText(), newPost.getText());
		return;		
	}
	
	
}
