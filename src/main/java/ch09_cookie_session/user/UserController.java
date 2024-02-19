package ch09_cookie_session.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/ch09/user/list","/ch09/user/register", "/ch09/user/update","/ch09/user/delete", "/ch09/user/login","/ch09/user/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService uSvc = new UserServiceImpl();
	String uid = null, pwd = null, pwd2 = null, uname = null, email = null; 
	String msg = "", url = "";
	User user = null;
	
	
	// session을 사용하는 이유는 내 정보 아이디 비밀번호 아이피 등등이 쿠키에 저장되서 사이트를 껏다가 
	//켜도 내 정보가 남아있어서 다시 켜도 남은 정보로 로그인 되도록 
	// 예를 들어서 넥슨 로그인 정보 기억하기 같은거 단 브라우저가 틀려지면 정보가 없어서 다시 입력해야함 
	// 크롬 엣지 둘이 로그인할때 서로 정보 따로 입력하듯이 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();    
		RequestDispatcher rd = null;
		
		switch (action) {
		case "list":
			String page_ = request.getParameter("page");
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			List<User>list = uSvc.getUserList(page);
			request.setAttribute("list", list);				// list값 넘겨주기
			rd = request.getRequestDispatcher("/ch09/user/list.jsp");
			rd.forward(request, response);
			break;
			
		case "login":
			if(method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch09/user/login.jsp");
				rd.forward(request, response);
			}else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				int result = uSvc.login(uid, pwd);
				if(result == uSvc.CORRECT_LOGIN) {
					user = uSvc.getUserByUid(uid);
					session.setAttribute("sessUid", uid);
					session.setAttribute("sessUname", user.getUname());
					msg = user.getUname() + "님 환영합니다.";
					url = "/jw/ch09/user/list?page=1";
				}else if(result == uSvc.WRONG_PASSWORD){
					msg = "패스워드가 틀립니다.";
					url = "/jw/ch09/user/login";
				}else {
					msg = "아이디 입력이 잘못되었습니다.";
					url = "/jw/ch09/user/login";
				}
				rd = request.getRequestDispatcher("/ch09/user/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;
			
		case "logout":
			session.invalidate();
			response.sendRedirect("/jw/ch09/user/list?page=1");
			break;
			
		case "register":
			if(method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch09/user/register.jsp");
				rd.forward(request, response);
			}else {
				pwd = request.getParameter("pwd");
				int result = uSvc.login(pwd);
			}
			break;
		
		case "update":
			if(method.equals("GET")) {
				
			}
			
		}
	}


}