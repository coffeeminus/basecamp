package vo;

/**
 * 게시판 정보를 담는 VO 클래스
 * @author yeji
 *
 */
public class BoardVO {
	private String email; 	//이메일
	private String pw; 		//비밀번호
	private String text;	//본문
	private String modTime; //수정시간
	
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
