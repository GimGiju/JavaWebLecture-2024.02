package dog.entity;

import java.time.LocalDate;

public class User {
	private int userId;
	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private int balance;

	public User() { }
	
	public User(int userId, String pwd, String uname, String email) {
		this.userId = userId;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
	}

	public User(String uid, String pwd, String uname, String email) {
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
	}

	public User(int userId, String uid, String pwd, String uname, String email) {
		this.userId = userId;
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
	}

	public User(int userId, String uid, String pwd, String uname, String email, LocalDate regDate, int isDeleted,
			int balance) {
		this.userId = userId;
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", email=" + email
				+ ", regDate=" + regDate + ", isDeleted=" + isDeleted + ", balance=" + balance + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
