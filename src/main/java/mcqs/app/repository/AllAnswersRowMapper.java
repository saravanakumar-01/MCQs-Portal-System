package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Answers;

public class AllAnswersRowMapper implements RowMapper<Answers>{

	@Override
	public Answers mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Answers answers = new Answers();
		answers.setCourseId(rs.getInt("course_id"));
		answers.setId(rs.getInt("id"));
		answers.setQuestion(rs.getString("question"));
		answers.setQuestionId(rs.getInt("question_id"));
		answers.setStatus(rs.getBoolean("status"));
		return answers;
	}

}
