package mcqs.app.entities;
  // Import Date class for handling date and time

public class Exams {
    private int examId;
    private int courseId;
    private User user;
    private int userId;
    private String examCourse;
    private String examDate;
	private int totalMarks;
    private double obtMarks;
    private String startTime;  // Using Date for date and time
    private String endTime;    // Using Date for date and time
    private String examTime;
    private boolean status;
    
    public Exams() {
		super();
	}

	public Exams(int examId, int courseId, int userId, String examCourse, String examDate,
			int totalMarks, double obtMarks, String startTime, String endTime, String examTime, boolean status) {
		super();
		this.examId = examId;
		this.courseId = courseId;
		this.userId = userId;
		this.examCourse = examCourse;
		this.examDate = examDate;
		this.totalMarks = totalMarks;
		this.obtMarks = obtMarks;
		this.startTime = startTime;
		this.endTime = endTime;
		this.examTime = examTime;
		this.status = status;
	}

	public Exams(int courseId, int userId, String examCourse, String examDate, int totalMarks,
			double obtMarks, String startTime, String endTime, String examTime, boolean status) {
		super();
		this.courseId = courseId;
		this.userId = userId;
		this.examCourse = examCourse;
		this.examDate = examDate;
		this.totalMarks = totalMarks;
		this.obtMarks = obtMarks;
		this.startTime = startTime;
		this.endTime = endTime;
		this.examTime = examTime;
		this.status = status;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getExamCourse() {
		return examCourse;
	}

	public void setExamCourse(String examCourse) {
		this.examCourse = examCourse;
	}

	public String getExamDate() {
		return examDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public double getObtMarks() {
		return obtMarks;
	}

	public void setObtMarks(double obtMarks) {
		this.obtMarks = obtMarks;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\n Exams [examId=" + examId + ", courseId=" + courseId + ", user=" + user
				+ ", userId=" + userId + ", examCourse=" + examCourse + ", examDate=" + examDate + ", totalMarks="
				+ totalMarks + ", obtMarks=" + obtMarks + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", examTime=" + examTime + ", status=" + status + "]";
	}
	
	
    
    

	
	
    
    

    
    
}

