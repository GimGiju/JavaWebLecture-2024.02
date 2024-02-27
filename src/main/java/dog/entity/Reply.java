package dog.entity;

import java.time.LocalDateTime;

public class Reply {
	private int replyId;
	private String comment;
	private LocalDateTime regTime;
	private int userId;				
	private int boardId;
	public Reply() { }
	@Override
	public String toString() {
		return "reply [replyId=" + replyId + ", comment=" + comment + ", regTime=" + regTime + ", userId=" + userId
				+ ", boardId=" + boardId + "]";
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDateTime getRegTime() {
		return regTime;
	}
	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}				
	
	
}
