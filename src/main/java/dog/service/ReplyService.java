package dog.service;

import java.util.List;

import dog.entity.Reply;

public interface ReplyService {
	
		 List<Reply> getReplyList(Reply reply);		//글 목록 얻어오기
		
		 void deleteReply(int replyId);						//댓글 삭제
		
		 void insertReply(Reply reply);				//댓글 추가
					
		 int getSequence();							//추가할 댓글의 글번호를 리턴하는 메소드
		
		 void updateReply(Reply reply);				//댓글 수정
		
		 Reply getData(int num);				//댓글 하나의 정보를 리턴하는 메소드
		
		 int getCount(int ref_group);					//댓글의 갯수를 리턴하는 메소드
	
}
