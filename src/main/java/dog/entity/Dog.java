package dog.entity;

import java.time.LocalDate;

public class Dog {
	private int dogId;
	private LocalDate bDate;
	private String breed;
	private String gender;
	private String dname;
	private int uId;

	public Dog() { }

	
	public Dog(int dogId, LocalDate bDate, String breed, String gender, String dname, int uId) {
		this.dogId = dogId;
		this.bDate = bDate;
		this.breed = breed;
		this.gender = gender;
		this.dname = dname;
		this.uId = uId;
	}


	@Override
	public String toString() {
		return "Dog [dogId=" + dogId + ", bDate=" + bDate + ", breed=" + breed + ", gender=" + gender + ", dname="
				+ dname + ", uId=" + uId + "]";
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

	public int getUid() {
		return uId;
	}

	public void setUid(int uId) {
		this.uId = uId;
	}
	
}
