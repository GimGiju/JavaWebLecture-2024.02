package dog.entity;

import java.time.LocalDate;

public class Dog {
	private int dogId;
	private LocalDate bDate;
	private String breed;
	private String gender;
	private String dname;
	private int userId;

	public Dog() { }

	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", bDate=" + bDate + ", breed=" + breed + ", gender=" + gender + ", dname="
				+ dname + ", userId=" + userId + "]";
	}

	public int getDogId() {
		return dogId;
	}

	public void setDogId(int dogId) {
		this.dogId = dogId;
	}

	public LocalDate getbDate() {
		return bDate;
	}

	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
