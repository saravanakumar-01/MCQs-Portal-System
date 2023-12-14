package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Course;

public class CourseRowMapper implements RowMapper<Course>{
	
	//`course_name`, `total_marks`, `time`

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Course course = new Course();
		course.setCourseId(rs.getInt("course_id"));
		course.setCourseName(rs.getString("course_name"));
		course.setTotalMarks(rs.getInt("total_marks"));
		course.setTime(rs.getString("time"));
		
		return course;
	}
	
	

}
