package dog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dog.entity.Dog;
import project.entity.User;

public class DogDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/bbs");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Dog getUserByDid(int dogId) {
		Connection conn = getConnection();
		String sql = "select * from user where dogId=?";
		Dog dog = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dogId);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dog = new Dog(rs.getInt(1), LocalDate.parse(rs.getString(2)), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getInt(6));
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dog;
	}
	
	public List<Dog> getUserList(int num, int offset) {
		Connection conn = getConnection();
		String sql = "select * from dog where isDeleted=0"
					+ " order by regDate desc, dogId limit ? offset ?";
		List<Dog> list = new ArrayList<Dog>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, offset);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Dog dog = new Dog(rs.getInt(1), LocalDate.parse(rs.getString(2)), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6));
				list.add(dog);
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insertUser(User user) {
		Connection conn = getConnection();
		String sql = "insert users values (?, ?, ?, ?, default, default)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getUname());
			pstmt.setString(4, user.getEmail());
			
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		Connection conn = getConnection();
		String sql = "update users set pwd=?, uname=?, email=? where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUid());
			
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String uid) {
		Connection conn = getConnection();
		String sql = "update users set isDeleted=1 where uid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			pstmt.executeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
