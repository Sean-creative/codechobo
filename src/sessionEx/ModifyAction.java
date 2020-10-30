package sessionEx;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filterEX.User;
import filterEX.UserDao;

@WebServlet("/ModifyAction")
public class ModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyAction() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao userDao = UserDao.getInstance();						
		String id = request.getParameter("id");		
		String button = request.getParameter("button");			
		
		// 1. 삭제라면.....
		if (isRemove(button)) {						
			userDao.deleteUser(id);						
		}						
		// 2. 수정이라면.....
		else if (isModify(button)) {											
			User user = userSet(request);			
			userDao.updateUser(user);						
		}
		
		// 3. 세션도 지워야 하니, logout.jsp로 보내기
		response.sendRedirect("logout.jsp");
		
	}

	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	
	protected boolean isRemove(String button) {
		if ( button.equals("remove")) {
			return true;
		}		
		return false;
	}
	
	protected boolean isModify(String button) {
		if ( button.equals("modify")) {
			return true;
		}		
		return false;
	}
	protected User userSet(HttpServletRequest request) {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		User user = new User(id, name, pwd, email);		
		return user;
	}
}
