package mcqs.app.repository;

import java.util.List;

import mcqs.app.entities.User;
import mcqs.app.entities.Course;

public interface UserDao {
	
	int insertUser(User user);
	
	User getUserData(String emailId);
	
	//Long getAdminIdForUserName(String userName);
	
	//List<Course> getCoursesForAdminId(Long adminId);
	
	int updateAdmin(User admin);
	
	User getAdminProfile(String email);
	
	List<User> getAllAdmin();
	
	int grantAccessForAdmin(String email);
	
	int revokeAccessForAdmin(String email);
	
	int updateStudent(User student);
	
	User getStudentProfile(String email);
	
	

	
	
	
}
