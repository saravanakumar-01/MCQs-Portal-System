package mcqs.app.entities;

public class Answers {
	
	private int answerId;
	private int questionId;
	private int id;
	private int courseId;
	private String question;
	private String answer;
	private String correctAnswer;
	private boolean status;
	
	public Answers() {
		super();
	}
	
	public Answers(int questionId, int id, int courseId, String question, String answer, boolean status) {
		super();
		this.questionId = questionId;
		this.id = id;
		this.courseId = courseId;
		this.question = question;
		this.answer = answer;
		this.status = status;
	}
	
	public Answers(int answerId, int questionId, int id, int courseId, String question, String answer,
			String correctAnswer, boolean status) {
		super();
		this.answerId = answerId;
		this.questionId = questionId;
		this.id = id;
		this.courseId = courseId;
		this.question = question;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
		this.status = status;
	}
	
	public Answers(int questionId, int id, int courseId, String question, String answer, String correctAnswer,
			boolean status) {
		super();
		this.questionId = questionId;
		this.id = id;
		this.courseId = courseId;
		this.question = question;
		this.answer = answer;
		this.correctAnswer = correctAnswer;
		this.status = status;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "\n Answers [answerId=" + answerId + ", questionId=" + questionId + ", id=" + id + ", courseId=" + courseId
				+ ", question=" + question + ", answer=" + answer + ", correctAnswer=" + correctAnswer + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
	

}
