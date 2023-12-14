package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mcqs.app.entities.Questions;

public class QuestionsRowMapper implements RowMapper<Questions> {

	@Override
	public Questions mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Questions question = new Questions();
		question.setQuestionId(rs.getInt("question_id"));
		question.setCourseId(rs.getInt("course_id"));
		question.setQuestionName(rs.getString("question_name"));
		question.setOpt1(rs.getString("opt1"));
		question.setOpt2(rs.getString("opt2"));
		question.setOpt3(rs.getString("opt3"));
		question.setOpt4(rs.getString("opt4"));
		question.setCorrect(rs.getString("correct"));
		
		return question;
	}

}
