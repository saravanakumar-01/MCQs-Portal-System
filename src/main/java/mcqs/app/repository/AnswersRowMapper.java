package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.CorrectAnswer;

public class AnswersRowMapper implements RowMapper<CorrectAnswer>{

	@Override
	public CorrectAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CorrectAnswer correctAnswer = new CorrectAnswer();
		
		correctAnswer.setCorrectAnswer(rs.getString("correct"));
		
		return correctAnswer;
	}
	
	



}
