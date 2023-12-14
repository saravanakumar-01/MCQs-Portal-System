package mcqs.app.repository;

import java.util.List;

import mcqs.app.entities.Course;

public interface CourseDao {
	
	int insertCourse(Course course);
	
	List<Course> getListOfCourses();
	
	int deleteCourse(int courseId);

}
