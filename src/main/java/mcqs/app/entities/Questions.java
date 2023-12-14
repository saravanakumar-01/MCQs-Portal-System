package mcqs.app.entities;

public class Questions {
	
	//`question_id`, `course_name`, `question`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`
	
	private int questionId;
	private int courseId;
	private Course course;
	private String questionName;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String correct;
	
	public Questions() {
		super();
	}

	public Questions(int questionId, int courseId, Course course, String questionName, String opt1, String opt2,
			String opt3, String opt4, String correct) {
		super();
		this.questionId = questionId;
		this.courseId = courseId;
		this.course = course;
		this.questionName = questionName;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correct = correct;
	}

	public Questions(int courseId, Course course, String questionName, String opt1, String opt2, String opt3,
			String opt4, String correct) {
		super();
		this.courseId = courseId;
		this.course = course;
		this.questionName = questionName;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.correct = correct;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "\n Questions [questionId=" + questionId + ", courseId=" + courseId + ", course=" + course
				+ ", questionName=" + questionName + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3 + ", opt4="
				+ opt4 + ", correct=" + correct + "]";
	}
	
	

	
	
	
	
	
	
	
	
	

}
