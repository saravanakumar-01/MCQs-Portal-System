package mcqs.app.entities;

import java.sql.Date;

public class User {
	
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String confirmPassword;
	private Date dateOfBirth;
	private String mobileNo;
	private String gender;
	private String address;
	private int role;
	private boolean status;
	private String pwdHash;
	private String pwdSalt;
	
	public User() {
		super();
	}

	
	public User(int id, String fullName, String email, String password, String confirmPassword, Date dateOfBirth,
			String mobileNo, String gender, String address, int role, boolean status) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.address = address;
		this.role = role;
		this.status = status;
	}


	public User(String fullName, String email, String password, String confirmPassword, Date dateOfBirth,
			String mobileNo, String gender, String address, int role, boolean status) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.address = address;
		this.role = role;
		this.status = status;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		
		this.dateOfBirth = dateOfBirth;
		
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

	public String getPwdHash() {
		return pwdHash;
	}


	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}


	public String getPwdSalt() {
		return pwdSalt;
	}


	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}


	@Override
	public String toString() {
		return "\n User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", dateOfBirth=" + dateOfBirth + ", mobileNo=" + mobileNo
				+ ", gender=" + gender + ", address=" + address + ", role=" + role + ", status=" + status + "]";
	}





	
	
	
	
	
	

}
