package ch99;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Result;

public class SongDao {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Song getSong(int sid) {
		Connection conn = getConnection();
		String sql ="select * from song where sid=?";
		Song song = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	public List<Song> getSongList(String title, int num, int offset) {
		Connection conn = getConnection();
		String sql = "select * from song where title=? limit ? offset ?";
		List<Song>list = new ArrayList<Song>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setInt(2, num);
			pstmt.setInt(3, offset);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Song song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				
				list.add(song);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
