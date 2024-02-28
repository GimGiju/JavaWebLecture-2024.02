package dog.service;

import java.util.List;

import dog.entity.Reply;

public interface ReplyService {
	
		public List<Reply> getList();			//글 목록 얻어오기
		
		public void delete(int num);			//댓글 삭제			
		
		public void insert(Reply reply);		//댓글 추가
			
		public int getSequence();				//추가할 댓글의 글번호를 리턴하는 메소드
		
		public void update(Reply reply);		//댓글 수정
		
		public Reply getData(int num);			//댓글 하나의 정보를 리턴하는 메소드
		
		public int getCount(int ref_group);		//댓글의 갯수를 리턴하는 메소드
	
}
