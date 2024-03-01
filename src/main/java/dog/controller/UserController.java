package dog.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dog.entity.User;
import dog.service.UserServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/dog/user/list","/dog/user/register","/dog/user/update",
            "/dog/user/delete","/dog/user/login","/dog/user/logout","/dog/home"})
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserServiceImpl uSvc = new UserServiceImpl();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String[] uri = request.getRequestURI().split("/");
        String action = uri[uri.length - 1];
        String method = request.getMethod();
        HttpSession session = request.getSession();
        RequestDispatcher rd = null;

        String uId = "", pwd = "", pwd2 = "", uname = "", email = "", hashedPwd = "";
        String msg = "", url = "";
        User user = null;

        switch (action) {
        	case "home":
                rd = request.getRequestDispatcher("/WEB-INF/dog/common/Home.jsp");
                rd.forward(request, response);
                break;
            case "list":
                String page_ = request.getParameter("page");
                int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
                session.setAttribute("currentUserPage", page);
                List<User> userList = uSvc.getUserList(page);
                request.setAttribute("userList", userList);

                // for pagination
                int totalUsers = uSvc.getUserCount();
                int totalPages = (int) Math.ceil(totalUsers * 1.0 / uSvc.COUNT_PER_PAGE);
                List<String> pageList = new ArrayList<String>();
                for (int i = 1; i <= totalPages; i++)
                    pageList.add(String.valueOf(i));
                request.setAttribute("pageList", pageList);


                rd = request.getRequestDispatcher("/WEB-INF/dog/user/list.jsp");
                rd.forward(request, response);
                break;

            case "login":
                if (method.equals("GET")) {
                    rd = request.getRequestDispatcher("/WEB-INF/dog/user/login.jsp");
                    rd.forward(request, response);
                } else {
                    uId = request.getParameter("uid");
                    pwd = request.getParameter("pwd");
                    int result = uSvc.login(uId, pwd);
                    if (result == uSvc.CORRECT_LOGIN) {
                        user = uSvc.getUserByUid(uId);
                        session.setAttribute("sessUid", uId);
                        session.setAttribute("sessUname", user.getUname());
                        session.setAttribute("sessBalance", user.getBalance());
                        msg = user.getUname() + "님 환영합니다.";
                        url = "/jw/dog/home";
                    } else if (result == uSvc.WRONG_PASSWORD) {
                        msg = "패스워드가 틀립니다.";
                        url = "/jw/dog/user/login";
                    } else {
                        msg = "아이디 입력이 잘못되었습니다.";
                        url = "/jw/dog/user/login";
                    }
                    rd = request.getRequestDispatcher("/WEB-INF/dog/common/alertMsg.jsp");
                    request.setAttribute("msg", msg);
                    request.setAttribute("url", url);
                    rd.forward(request, response);
                }
                break;

            case "logout":
                session.invalidate();
                response.sendRedirect("/jw/dog/user/login");
                break;

            case "register":
                if (method.equals("GET")) {
                    session.invalidate();
                    rd = request.getRequestDispatcher("/WEB-INF/dog/user/register.jsp");
                    rd.forward(request, response);
                } else {
                    uId = request.getParameter("uId");
                    pwd = request.getParameter("pwd");
                    pwd2 = request.getParameter("pwd2");
                    uname = request.getParameter("uname");
                    email = request.getParameter("email");
                    if (uSvc.getUserByUid(uId) != null) {
                        rd = request.getRequestDispatcher("/WEB-INF/dog/common/alertMsg.jsp");
                        request.setAttribute("msg", "아이디가 중복입니다.");
                        request.setAttribute("url", "/jw/dog/user/register");
                        rd.forward(request, response);
                    } else if (pwd.equals(pwd2)) {
                        user = new User(uId, pwd, uname, email);
                        uSvc.registerUser(user);
                        response.sendRedirect("/jw/dog/user/list?page=1");
                    } else {
                        rd = request.getRequestDispatcher("/WEB-INF/dog/common/alertMsg.jsp");
                        request.setAttribute("msg", "패스워드 입력이 잘못되었습니다.");
                        request.setAttribute("url", "/jw/dog/user/register");
                        rd.forward(request, response);
                    }
                }
                break;

            case "update":
                if (method.equals("GET")) {
                    uId = request.getParameter("uId");
                    user = uSvc.getUserByUid(uId);
                    rd = request.getRequestDispatcher("/WEB-INF/dog/user/update.jsp");
                    request.setAttribute("user", user);
                    rd.forward(request, response);
                } else {
                    uId = (String)session.getAttribute("sessUid");
                    pwd = request.getParameter("pwd");
                    pwd2 = request.getParameter("pwd2");
                    hashedPwd = request.getParameter("hashedPwd");
                    uname = request.getParameter("uname");
                    email = request.getParameter("email");
                    int balance = (int)session.getAttribute("sessBalance");
                    if (pwd != null && pwd.equals(pwd2))
                        hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
                    user = new User(uId, hashedPwd, uname, email, balance);
                    uSvc.updateUser(user);
                    session.setAttribute("sessUid",user.getuId());
                    session.setAttribute("sessBalance",user.getBalance());
                    session.setAttribute("sessUname",user.getUname());

                    response.sendRedirect("/jw/dog/user/list?page=1");
                }
                break;

            case "delete":
                uId = request.getParameter("uId");
                uSvc.deleteUser(uId);
                String sessUid = (String) session.getAttribute("sessUid");
                if (!sessUid.equals("admin"))
                    session.invalidate();
                response.sendRedirect("/jw/dog/user/list?page=1");
                break;
        }


    }
}
