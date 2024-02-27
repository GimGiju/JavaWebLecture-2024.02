package dog.entity;


public class Gallery {
	private int galleryId;
	private String title;
	private String content;
	private int isDeleted;
	private int viewCount;
	private int replyCount;
	private String fNmame;
	private int userId;
	public Gallery() { }
	@Override
	public String toString() {
		return "gallery [galleryId=" + galleryId + ", title=" + title + ", content=" + content + ", isDeleted="
				+ isDeleted + ", viewCount=" + viewCount + ", replyCount=" + replyCount + ", fNmame=" + fNmame
				+ ", userId=" + userId + "]";
	}
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
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
	public String getfNmame() {
		return fNmame;
	}
	public void setfNmame(String fNmame) {
		this.fNmame = fNmame;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
