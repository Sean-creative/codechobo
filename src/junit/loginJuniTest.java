package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.DriverManager;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import filterEX.User;
import filterEX.UserDao;

//인서트를 하더라도 중복되었을 때 하나 해보고, 중복 안되었을 떄 해보고 
//최대한 다양하고 많이 써야한다.
//고민 많이 해보고, 스스로 나오는게 있어야 한다. update,select 다 해봐야 한다.
class loginJuniTest {

	// 각 테스트 메서드에서 사용
	static UserDao userDao = UserDao.getInstance();

	@BeforeAll
	static void beforeAll() {
		System.out.println("before all");
		String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String DB_USER = "LOGIN_EX";
		String DB_PASSWORD = "LOGIN_EX";

		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			userDao.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			userDao.stmt = userDao.conn.createStatement(); // Statement를 가져온다.
		} catch (Exception e) {
			System.err.println("리스너 드라이버 로딩 중 오류발생 : \n");
			e.printStackTrace();
		}
	}

	@AfterAll
	static void afterAll() {
		System.out.println("after all");
		try {		
			userDao.stmt.close();
			userDao.rs.close();
			userDao.conn.close();
		} catch (Exception e) {
			System.err.println("리스너 드라이버 닫던 중 오류발생 : \n");
			e.printStackTrace();
		}
	}

//	@Test
	void insertUserTest() {
//		int random = (int)(Math.random()*10000000);

		User user = new User("ksw6125000", "0", "0", "0");
		// insert가 되면 1이 반환 된다.
		assertEquals(1, userDao.insertUser(user));
	}

//	@Test
	void insertFalseUserTest() {

		User user = new User("ksw6125000", "0", "0", "0");
		// insert가 되면 1이 반환 된다.
		assertEquals(1, userDao.insertUser(user));
	}

//	@Test
	void selectUserTest() {
		// id에 맞는 User를 반환
		String userId = "test1119";
		User user = userDao.selectUser(userId);
		assertEquals(userId, user.getId());
	}
	
	@Test
	void allDelAndSelectTest() {
		// 테이블의 데이터를 모두 삭제 후에 select
		userDao.deleteAllUser();
		String userId = "test1119";
		User user = userDao.selectUser(userId);
		assertEquals(null, user.getId());
	}

//	@Test
	void selectUserFalseTest() {

		// id에 맞는 User를 반환
		String userId = "ksw";
		User user = userDao.selectUser(userId);
		assertEquals(userId, user.getId());
	}

//	@Test
	void deleteUserTest() {

		String userId = "test1119";
		assertEquals(1, userDao.deleteUser(userId));
	}

//	@Test
	void updateUserTest() {
		User u = new User("ksw6125000", "김선우2", "0000", "ksw6125000@daum.net");
		assertEquals(1, userDao.updateUser(u));
	}

//	  @Test 
	public void selectAllUsersTest() {
		List<User> userList = userDao.selectAllUsers();
		int count = userList.size();

		User u = new User("test1119", "test", "test", "test119@aa");
		assertTrue(userDao.insertUser(u) + count == userDao.selectAllUsers().size());
	}

//	@Test
	public void deleteAllUserTest() {
		userDao.deleteAllUser();
		User u = new User("test1119", "test", "test", "test119@aa");
		userDao.insertUser(u);
		assertTrue(userDao.selectAllUsers().size() == 1);
	}

}
