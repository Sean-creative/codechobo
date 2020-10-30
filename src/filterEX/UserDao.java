package filterEX;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
                  
              
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public String query;
	public PreparedStatement pstmt;
	 
	private UserDao() {
	}

	static UserDao userDao = new UserDao();
	
	public static UserDao getInstance() {
		return userDao;
	}
	
	
	public int insertUser(User u) {
		query = "INSERT INTO REGISTER VALUES(?,?,?,?)";
		System.out.println(query);

		try {		
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getPwd());
			pstmt.setString(4, u.getEmail());

			int update_su = pstmt.executeUpdate();
			System.out.println("완료된 레코드 수 : " + update_su);
			
			pstmt.close();
		} catch (Exception e) {
			System.err.println("오류발생 : " + e);
			return -1;
		}
		return 1;
	}

		
	// id값을 인자로 주면, 그에맞는 User를 반환
	public User selectUser(String userId) {

		User user = new User();
		String query = "select * from REGISTER where id='" + userId + "'";
		System.out.println(query);

		try {				
			rs = stmt.executeQuery(query); // SQL문을 실행한다.
			
			if (rs.next()) {
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPwd(rs.getString("PWD"));
				user.setEmail(rs.getString("EMAIL"));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}
	
	
	// 테이블에 있는 모든 유저의 정보를 반환
	public List<User> selectAllUsers() {
		List<User> userList = new ArrayList<>();

		query = "select * from REGISTER";
		System.out.println(query);

		try {
			rs = stmt.executeQuery(query); // SQL문을 실행한다.

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("ID"));
				user.setName(rs.getString("NAME"));
				user.setPwd(rs.getString("PWD"));
				user.setEmail(rs.getString("EMAIL"));
				userList.add(user);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} 
		return userList;
	}
	
	
	
	public int deleteUser(String userId) {
		
		String query = "delete from REGISTER where id='" + userId + "'";
		System.out.println(query);

		try {
			rs = stmt.executeQuery(query); // SQL문을 실행한다.			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
		return 1;
	}
	
	
public int deleteAllUser() {
		
		String query = "delete from REGISTER";
		System.out.println(query);

		try {		
			rs = stmt.executeQuery(query); // SQL문을 실행한다.
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
		return 1;
	}
	
	
	
	public int updateUser(User u) {
		query = "UPDATE REGISTER SET NAME=?, PWD=?, EMAIL=? "
				+ "WHERE ID = '"+u.getId() +"'";
		System.out.println(query);

		try {
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getPwd());
			pstmt.setString(3, u.getEmail());

			int update_su = pstmt.executeUpdate();
			System.out.println("완료된 레코드 수 : " + update_su);	
			
			pstmt.close();
		} catch (Exception e) {
			System.err.println("오류발생 : " + e);
			return -1;
		}
		return 1;
	}
	
	
	
}
