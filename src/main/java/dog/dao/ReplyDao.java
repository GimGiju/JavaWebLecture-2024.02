package dog.dao;

import java.sql.Connection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dog.entity.Reply;

public class ReplyDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/dog");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<Reply> getReplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertReply(Reply reply) {
		// TODO Auto-generated method stub
		
	}

	public void delteReply(int replyId) {
		// TODO Auto-generated method stub
		
	}

	public void updateReply(Reply reply) {
		// TODO Auto-generated method stub
		
	}
}
