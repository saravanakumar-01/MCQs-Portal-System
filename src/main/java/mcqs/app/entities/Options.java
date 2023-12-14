package mcqs.app.entities;

public class Options {
	
	// `option_id`, `question_id`, `option_text`, `is_correct`
	
	private int optionId;
	Questions questions;
	private String optionText;
	private boolean isCorrect;
	public Options() {
		super();
	}
	public Options(int optionId, Questions questions, String optionText, boolean isCorrect) {
		super();
		this.optionId = optionId;
		this.questions = questions;
		this.optionText = optionText;
		this.isCorrect = isCorrect;
	}
	public Options(Questions questions, String optionText, boolean isCorrect) {
		super();
		this.questions = questions;
		this.optionText = optionText;
		this.isCorrect = isCorrect;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	@Override
	public String toString() {
		return "\n Options [optionId=" + optionId + ", questions=" + questions + ", optionText=" + optionText
				+ ", isCorrect=" + isCorrect + "]";
	} 
	
	
	
	

}
