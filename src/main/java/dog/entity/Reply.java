package dog.entity;

import java.time.LocalDateTime;

public class Reply {
	private int replyId;					// 글번호
	private String comment;					// 댓글 내용
	private LocalDateTime regTime;			// 작성시간
	private int userId;						// 댓글 작성자 아이디
	private int boardId;					// ?
	private int targetId;					// 댓글의 대상자 아이디
	private int refGroup;					// 원들의 글번호
	private int commentGroup;				// 댓글의 그룹번호
	private int isDelete;					// 삭제된 댓글인지 여부

	public Reply() { }

}
