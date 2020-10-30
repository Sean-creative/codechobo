package filterEX;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LogFilter", urlPatterns = { "/board.jsp"})
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터 초기화 됨");
	}
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// A. 서블릿이 요청을 받기 전에 처리할 작업 작성(요청 전처리 작업)
		System.out.println("[start]" + new Date());

		// A.0 세션 값을 가져오기전에 전처리 
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		// A.1. 세션에서 값을 가져온다. 
		String sID = (String) session.getAttribute("id");

		// A.2. 키가 없다면 로그인 페이지로 보낸다.		
		if (isNotValidKey(sID)) { 
			res.sendRedirect("loginForm.jsp?destination=board.jsp");
		}
		
		// B. 다음 filter가 작업을 할 수 있게 요청과 응답을 전달(그대로 사용)
		chain.doFilter(request, response);

		// C. 서블릿이 응답한 직후에 처리할 작업 작성(응답 후처리 작업)
		System.out.println("[end]" + new Date());
	}

	
	public void destroy() {
		// filter가 제거되기 전에 수행되어야 할 마무리 작업 작성
		System.out.println("필터 제거됨.");
	}
	
	
	public boolean isNotValidKey(String sID) {
		if (sID == null)
				return true;
		return false;
	}
	
	
} 
