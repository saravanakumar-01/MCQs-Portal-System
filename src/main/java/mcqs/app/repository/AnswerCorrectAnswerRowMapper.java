package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Answers;

public class AnswerCorrectAnswerRowMapper implements RowMapper<Answers>{

	@Override
	public Answers mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Answers viewAnswers = new Answers();
		viewAnswers.setAnswer(rs.getString("answer"));
		viewAnswers.setCorrectAnswer(rs.getString("correct_answer"));
		return viewAnswers;
	}
	
	

}
