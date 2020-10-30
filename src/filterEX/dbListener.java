package filterEX;
import java.sql.DriverManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class dbListener implements ServletContextListener {

	UserDao userDao;

	public dbListener() {
		System.out.println("리스너 생성자와 초기화 메소드는 무엇이 다를까.....");
	}

	
	public void contextInitialized(ServletContextEvent sce) {
		userDao = UserDao.getInstance();
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";		
		String DB_USER = "LOGIN_EX";
		String DB_PASSWORD = "LOGIN_EX";
		
		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			userDao.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			userDao.stmt = userDao.conn.createStatement(); // Statement를 가져온다.
		} catch (Exception e) {
			System.err.println("리스너 드라이버 로딩 중 오류발생 : \n" + e);
		}
		System.out.println("리스너 Start");
	}

	
	public void contextDestroyed(ServletContextEvent sce) {

		try {
			userDao.conn.close();
			userDao.rs.close();
			userDao.stmt.close();
			userDao.pstmt.close();
		} catch (Exception e) {
			System.err.println("리스너 드라이버 닫던 중 오류발생 : \n" + e);
		}

		System.out.println("리스너 End");
	}
}
