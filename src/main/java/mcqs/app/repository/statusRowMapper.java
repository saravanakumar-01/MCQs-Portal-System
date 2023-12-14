package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Answers;
import mcqs.app.entities.CorrectAnswer;

public class statusRowMapper implements RowMapper<Integer>{

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int correctCount = rs.getInt("correctAnswerCount");
		return correctCount;
	}

	

	//correctAnswerCount

}
