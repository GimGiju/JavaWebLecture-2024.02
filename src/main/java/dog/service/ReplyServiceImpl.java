package dog.service;

import java.util.List;

import dog.dao.ReplyDao;
import dog.entity.Reply;

public class ReplyServiceImpl implements ReplyService {
	private ReplyDao rDao = new ReplyDao();
	
	@Override
	public List<Reply> getReplyList(Reply reply) {
		List<Reply>list = rDao.getReplyList();
		return list;
	}

	@Override
	public void deleteReply(int replyId) {
		rDao.delteReply(replyId);
		
	}

	@Override
	public void insertReply(Reply reply) {
		rDao.insertReply(reply);
		
	}

	@Override
	public int getSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateReply(Reply reply) {
		rDao.updateReply(reply);
		
	}

	@Override
	public Reply getData(int replyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount(int ref_group) {
		// TODO Auto-generated method stub
		return 0;
	}



}
