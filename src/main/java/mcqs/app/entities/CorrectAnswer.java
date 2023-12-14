package mcqs.app.entities;

public class CorrectAnswer {
	
	private int correctCount;
	
	private String correctAnswer;

	public CorrectAnswer(String correctAnswer) {
		super();
		this.correctAnswer = correctAnswer;
	}

	public CorrectAnswer() {
		super();
	}

	public CorrectAnswer(int correctCount) {
		super();
		this.correctCount = correctCount;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	
	

	
	
	
	
	
	

}
