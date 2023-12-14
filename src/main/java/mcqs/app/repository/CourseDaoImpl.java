package mcqs.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mcqs.app.entities.Course;

public class CourseDaoImpl implements CourseDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	@Override
	public int insertCourse(Course course) {
		
		String INSERT_COURSE = "INSERT INTO courses (`course_name`, `total_marks`, `time`) VALUES (?, ?, ?)";
		
		return jdbcTemplate.update(INSERT_COURSE, course.getCourseName(), course.getTotalMarks(), course.getTime());
	}

	@Override
	public List<Course> getListOfCourses() {
		
		List<Course> courseList = new ArrayList<Course>();
		
		String GET_COURSES = "SELECT * FROM courses";
	
		courseList = jdbcTemplate.query(GET_COURSES, new CourseRowMapper());
		
		return courseList;
	}

	@Override
	public int deleteCourse(int courseId) {
		
		String DELETE_COURSES = "DELETE FROM courses WHERE course_id = ?";
		return jdbcTemplate.update(DELETE_COURSES, courseId);
	}

	
	

}
