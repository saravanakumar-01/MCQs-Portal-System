package mcqs.app.entities;

public class Login {
	
	private String username;
	private String password;
	private String pwdSalt;
	private String pwdHash;
	
	
	public Login() {
		super();
	}


	public Login(String username, String password, String pwdSalt, String pwdHash) {
		super();
		this.username = username;
		this.password = password;
		this.pwdSalt = pwdSalt;
		this.pwdHash = pwdHash;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPwdSalt() {
		return pwdSalt;
	}


	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}


	public String getPwdHash() {
		return pwdHash;
	}


	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}


	@Override
	public String toString() {
		return "\n Login [username=" + username + ", password=" + password + ", pwdSalt=" + pwdSalt + ", pwdHash="
				+ pwdHash + "]";
	}
	
	
	
	

}
