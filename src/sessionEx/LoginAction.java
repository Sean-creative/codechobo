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

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAction() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 보드를 눌러서 -> 로그인에 성공한 사람은 -> 원래 목적지인 보드로 가야한다.
		// 어디서 왔는지 파라미터를 통해 확인한다, 없다면 -> ""로 들어간다.
		String destination = request.getParameter("destination");

		// 작업 - 사용자의 로그인 성공 여부에 따라 어떤 JSP로 보낼지 판단
		destination = isPass(request, destination);
		System.out.println("destination(LoginAction.java)  " + destination);

		response.sendRedirect(destination);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	
	// 사용자의 로그인 성공 여부에 따라 어떤 JSP로 보낼지 판단하는 메서드
	protected String isPass(HttpServletRequest request, String destination) {

		// 1. 전처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		// 2. 작업
		// 2.A 유저가 로그인을 성공했을 떄
		if (checkInfo(id, pwd)) {
			// 2.A.1 세션에 등록해준다.
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}

		// 2.B 로그인에 실패하면
		else {
			// 2.B.1 다시 로그인 하는 곳으로 보낸다.
			destination = "loginForm.jsp?destination=" + destination;
		}
		return destination;
	}

	
	
	// 사용자가 입력한 id,pwd를 DB와 값을 대조해서 체크하는 메서드
	protected boolean checkInfo(String id, String pwd) {

		UserDao userDao = UserDao.getInstance();
		User user = userDao.selectUser(id);

		if (id.equals(user.getId()) && pwd.equals(user.getPwd()))
			return true;
		return false;
	}
}
