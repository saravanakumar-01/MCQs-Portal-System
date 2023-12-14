package mcqs.app.entities;

public class Course {
	
	private int courseId;
	private String courseName;
	private int totalMarks;
	private String time;
	
	
	public Course() {
		super();
	}


	public Course(int courseId,String courseName, int totalMarks, String time) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.totalMarks = totalMarks;
		this.time = time;
	}
	
	
	public Course(String courseName, int totalMarks, String time) {
		super();
		this.courseName = courseName;
		this.totalMarks = totalMarks;
		this.time = time;
	}
	
	


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getTotalMarks() {
		return totalMarks;
	}


	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "\n Course [courseId=" + courseId + ", courseName=" + courseName + ", totalMarks=" + totalMarks + ", time="
				+ time + "]";
	}

	

	
	
	
	
	

}
