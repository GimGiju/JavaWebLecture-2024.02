package dog.entity;

public class Liked {
	private int likedId;
	private int galleryId;
	private int userId;
	public Liked() { }
	@Override
	public String toString() {
		return "liked [likedId=" + likedId + ", galleryId=" + galleryId + ", userId=" + userId + "]";
	}
	public int getLikedId() {
		return likedId;
	}
	public void setLikedId(int likedId) {
		this.likedId = likedId;
	}
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
