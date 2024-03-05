package test.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.entity.Member;

import java.io.IOException;


@WebServlet("/exam/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Member member = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m1 = new Member(1, "제임스", 17 , "미국");
		Member m2 = new Member(2, "마리아", 20, "한국");
		Member m3 = new Member(3, "브라이언", 30, "미국");
		Member m4 = new Member(4, "사라", 25, "미국");
		Member m5 = new Member(5, "다니엘", 18, "영국");
		
		Member[] members = {m1, m2, m3, m4, m5};
		request.setAttribute("members", members);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/exam/member/view.jsp");
		rd.forward(request, response);
	}


}
