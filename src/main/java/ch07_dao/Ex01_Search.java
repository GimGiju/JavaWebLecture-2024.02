package ch07_dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ch07/city/search")
public class Ex01_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (request.getParameter("id") == null) ? 2340 : Integer.parseInt(request.getParameter("id"));
		// id" 파라미터가 존재하지 않거나 값이 null이라면, request.getParameter("id") 의 결과는 null임
		//request.getParameter("id")가 null인 경우에는 2330을 사용하고 그렇지 않은 경우에는 해당 값을 정수로 변환하여 id 변수에 저장합니다
		CityDao cDao = new CityDao();
		City city = cDao.getCity(id);
		System.out.println(city);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(city);
		
	}
	
}
