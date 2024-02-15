package ch99;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ch99/song/list")
public class x02_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		title = (title == null || title.equals("")) ? "A" : title;
		String num_ = request.getParameter("num");
		int num = (num_ == null || num_.equals("")) ? 10 : Integer.parseInt(num_);
		String offset_ = request.getParameter("offset");
		int offset = (offset_ == null || offset_.equals("")) ? 0 : Integer.parseInt(offset_);
		
		SongDao sDao = new SongDao();
		List<Song>list = sDao.getSongList(title, num, offset);
		list.forEach(x -> System.out.println(x));
		
		String data = "";
		for (Song s : list) {
			data += "<tr>";
			data += "	<td>" + s.getSid() + "</td>";	
			data += "	<td>" + s.getTitle() + "</td>";	
			data += "	<td>" + s.getLyrics() + "</td>";	
			data += "</tr>";
		}
		
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>Song List</title>"
				+ "	<style>"
				+ "		th, td{padding: 3px;}"
				+ "	</style>"
				+ "</head>"
				+ "<body style=\"margin: 50px;\">"
				+ "	<h1>Song List</h1>"
				+ "	<hr>"
				+ "	<table border = \"1\">"
				+ "		<tr><th>아이디</th><th>타이틀</th><th>가사</th></tr>";
		html += data;		
		html += "   </table>"
				+ "</body>"
				+ "</html>";
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
				
	}

}
