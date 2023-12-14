package mcqs.app.entities;

public class Accounts {
	
	private String name;
	private String email;
	private String date;
	private String courseName;
	private double marks;
	private boolean status;
	
	public Accounts() {
		super();
	}

	public Accounts(String name, String email, String date, String courseName, double marks, boolean status) {
		super();
		this.name = name;
		this.email = email;
		this.date = date;
		this.courseName = courseName;
		this.marks = marks;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\n Accounts [name=" + name + ", email=" + email + ", date=" + date + ", courseName=" + courseName
				+ ", marks=" + marks + ", status=" + status + "]";
	}
	
	
	
	
	
	

}
