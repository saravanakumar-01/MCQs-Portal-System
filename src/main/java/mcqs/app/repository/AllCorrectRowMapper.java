package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Answers;

public class AllCorrectRowMapper implements RowMapper<Answers> {

	@Override
	public Answers mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Answers answers = new Answers();
		answers.setId(rs.getInt("id"));
		answers.setCorrectAnswer(rs.getString("correct_answer"));
		answers.setQuestion(rs.getString("question"));
		answers.setCourseId(rs.getInt("course_id"));
		answers.setStatus(rs.getBoolean("status"));
		answers.setAnswer(rs.getString("answer"));
		answers.setAnswerId(rs.getInt("answer_id"));
		answers.setQuestionId(rs.getInt("question_id"));
		return answers;
	}

}
