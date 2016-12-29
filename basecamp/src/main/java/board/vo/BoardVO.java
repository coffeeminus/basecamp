package board.vo;

/**
 * 게시판 vo 클래스
 * @author yeji
 *
 */
public class BoardVO {
	private String postId;
	private String email;
	private String pw;
	private String text;
	private String modTime;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getText() {
		return text;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getModTime() {
		return modTime;
	}
	public void setModTime(String modTime) {
		this.modTime = modTime;
	}	
}
