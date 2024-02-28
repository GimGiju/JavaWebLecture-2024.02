package dog.entity;

import java.time.LocalDateTime;

public class Board {
	private int boardId;
	private String title;
	private String content;
	private LocalDateTime modTime;
	private int isDeleted;
	private int viewCount;
	private int replyCount;
	private String uid;

	public Board() { }

	public Board(String title, String content, String uid) {
		this.title = title;
		this.content = content;
		this.uid = uid;
	}

	public Board(int boardId, String title, String content) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
	}

	public Board(int boardId, String title, String content, LocalDateTime modTime) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
	}

	public Board(int boardId, String title, String content, LocalDateTime modTime, int isDeleted, int viewCount,
			int replyCount, String uid) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", modTime=" + modTime
				+ ", isDeleted=" + isDeleted + ", viewCount=" + viewCount + ", replyCount=" + replyCount + ", uid="
				+ uid + "]";
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getModTime() {
		return modTime;
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	
}
