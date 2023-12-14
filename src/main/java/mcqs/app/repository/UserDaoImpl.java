package mcqs.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mcqs.app.entities.User;
import mcqs.app.entities.Course;
import mcqs.app.utils.Utils;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public int insertUser(User user) {
		
		final String REGISTER_ADMIN = "INSERT INTO "
				+ "user (`name`, `email`, `mobile`, `password_salt`, `password_hash`, "
				+ "`dob`, `gender`, `address`, `role`, `status`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		//we have to insert password_salt & password_hash
		String pwdSalt = Utils.generatePasswordSalt(10);
		String newPassword = pwdSalt + user.getPassword();
		String pwdHash = Utils.generatePasswordHash(newPassword);
		
		System.out.println("\n Password = "+user.getConfirmPassword());
		System.out.println("\n Password_Salt = "+pwdSalt);
		System.out.println("\n Password_Hash = "+pwdHash);
		
		
		return jdbcTemplate.update(REGISTER_ADMIN, user.getFullName(), 
				user.getEmail(), user.getMobileNo(), pwdSalt, pwdHash, 
				user.getDateOfBirth(), user.getGender(), user.getAddress(), 
				user.getRole(), user.isStatus()
				);
		
	}
	
	@Override
	public User getUserData(String emailId) {
		
		String GET_PASSWORD = "SELECT * FROM user WHERE email = ?";
		
		return jdbcTemplate.queryForObject(GET_PASSWORD, new UserRowMapper(), emailId);
		
	}
	
	/*
	 * public Long getAdminIdForUserName(String userName) { String GET_ID =
	 * "SELECT id FROM user WHERE email = ?"; return
	 * jdbcTemplate.queryForObject(GET_ID, Long.class, userName); }
	 * 
	 */
	@Override
	public int updateAdmin(User admin) {
		
		String GET_ADMIN="UPDATE user set name=?, mobile=?, dob=?, gender=?, address=? WHERE email=?";
		
		System.out.println(admin.getEmail());
		return jdbcTemplate.update(GET_ADMIN, 
				admin.getFullName(), 
				admin.getMobileNo(), 
				admin.getDateOfBirth(), 
				admin.getGender(), 
				admin.getAddress(),
				admin.getEmail());
	}
	@Override
	public User getAdminProfile(String email) {
		
		String GET_PROFILE = "SELECT * FROM user WHERE email=?";
		
		return jdbcTemplate.queryForObject(GET_PROFILE, new AdminProfileRowMapper(), email);
	
	}

	/*
	 * @Override public List<Course> getCoursesForAdminId(Long adminId) { String
	 * GET_COURSES = "SELECT * FROM COURSE WHERE id = ?";
	 * 
	 * return jdbcTemplate.queryForList(GET_COURSES, Course.class, adminId); }
	 */
	
	@Override
	public List<User> getAllAdmin() {
		String GET_ALLADMIN = "SELECT * FROM user WHERE role=?";
		return jdbcTemplate.query(GET_ALLADMIN, new UserRowMapper(), 2);
		
	}

	@Override
	public int grantAccessForAdmin(String email) {
		String UPDATE_GRANT = "UPDATE user set status=? WHERE email=?";
		return jdbcTemplate.update(UPDATE_GRANT, true, email);
	}

	@Override
	public int revokeAccessForAdmin(String email) {
		String UPDATE_REVOKE = "UPDATE user set status=? WHERE email=?";
		return jdbcTemplate.update(UPDATE_REVOKE, false, email);
	}
	
	@Override
	public int updateStudent(User student) {
		
		String GET_UPDATE = "UPDATE user set name=?, mobile=?, dob=?, gender=?, address=? WHERE email=?";
		
		System.out.println(student.getEmail());
		return jdbcTemplate.update(GET_UPDATE, 
				student.getFullName(),
				student.getMobileNo(),
				student.getDateOfBirth(),
				student.getGender(),
				student.getAddress(),
				student.getEmail());
	}

	@Override
	public User getStudentProfile(String email) {
		
		String GET_PROFILE = "SELECT * FROM user WHERE email=?";
		
		return jdbcTemplate.queryForObject(GET_PROFILE, new StudentProfileRowMapper(), email);
	}


	
	
}
