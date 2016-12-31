package toast.basecamp.board;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 * mysql 데이터베이스 연결 상태를 테스트 하는 클래스
 */

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/board_db";
	private static final String USER = "root";
	private static final String PW = "0000";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			//연결이 되었을때 확인만 하기
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
