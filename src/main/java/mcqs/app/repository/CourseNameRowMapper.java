package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Course;

public class CourseNameRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Course courseName = new Course();
		courseName.setCourseName(rs.getString("course_name"));
		return courseName;
	}
	
	

}
