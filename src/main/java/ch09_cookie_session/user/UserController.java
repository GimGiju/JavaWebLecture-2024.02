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

import org.mindrot.jbcrypt.BCrypt;

@WebServlet({"/ch09/user/list", "/ch09/user/register", "/ch09/user/update", 
			 "/ch09/user/delete", "/ch09/user/login", "/ch09/user/logout"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uSvc = new UserServiceImpl();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String uid = "", pwd = "", pwd2 = "", uname = "", email = "", hashedPwd = "";
		String msg = "", url = "";
		User user = null;
		
		switch (action) {
		case "list":
			String page_ = request.getParameter("page");
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			List<User> list = uSvc.getUserList(page);
			request.setAttribute("list", list);
//			rd = request.getRequestDispatcher("/ch09/user/list.jsp");
			rd = request.getRequestDispatcher("/ch09/user/listBS.jsp");
			rd.forward(request, response);
			break;
			
		case "login":
			if (method.equals("GET")) {
//				rd = request.getRequestDispatcher("/ch09/user/login.jsp");
				rd = request.getRequestDispatcher("/ch09/user/loginBS.jsp");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				int result = uSvc.login(uid, pwd);
				if (result == uSvc.CORRECT_LOGIN) {
					user = uSvc.getUserByUid(uid);
					session.setAttribute("sessUid", uid);
					session.setAttribute("sessUname", user.getUname());
					msg = user.getUname() + "님 환영합니다.";
					url = "/jw/ch09/user/list?page=1";
				} else if (result == uSvc.WRONG_PASSWORD) {
					msg = "패스워드가 틀립니다.";
					url = "/jw/ch09/user/login";
				} else {
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
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				pwd2 = request.getParameter("pdw2");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				if(uSvc.getUserByUid(uid) !=null) {
					re
				}
			}
			break;
		
		case "update":
			if(method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch09/user/delete.jsp");
				rd.forward(request, response);
			}
		case "delete":
			if(method.equals("GET")) {
				uid =request.getParameter("uid");				// request 객체의 getParamaeter 메서드로 사용자가 입력한 데이터를 가져올수있음
				uSvc.deleteUser(uid);
				String sessUid = (String) session.getAttribute("sessUid");		// session.getAttribute 세션에 저장된 값을 불러오는것
				if( !sessUid.equals("admin")) {				// 세션에 저장 되어있는 아이디와
					session.invalidate();					// invalidatedms 세션에 저장된 데이터를 모두 없애는 기능
				}
				response.sendRedirect("/jw/ch09/user/list?page=1");
			}break;
		}
	}
}