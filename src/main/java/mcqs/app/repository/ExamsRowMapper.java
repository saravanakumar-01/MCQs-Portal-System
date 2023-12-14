package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Exams;

public class ExamsRowMapper implements RowMapper<Exams>{

	@Override
	public Exams mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Exams exams = new Exams();
		
		exams.setCourseId(rs.getInt("course_id"));
		exams.setUserId(rs.getInt("id"));
		exams.setExamId(rs.getInt("exam_id"));
		exams.setExamCourse(rs.getString("course_name"));
		exams.setExamTime(rs.getString("exam_time"));
		exams.setTotalMarks(rs.getInt("total_marks"));
		exams.setStartTime(rs.getString("start_time"));
		exams.setEndTime(rs.getString("end_time"));
		exams.setObtMarks(rs.getDouble("obt_marks"));
		exams.setExamDate(rs.getString("date"));
		exams.setStatus(rs.getBoolean("status"));
		
		return exams;
	}

}
