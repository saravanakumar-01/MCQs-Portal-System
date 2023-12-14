package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mcqs.app.entities.User;

public class StudentProfileRowMapper implements RowMapper<User>{
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User student = new User();
		
		student.setId(rs.getInt("id"));
		
		student.setFullName(rs.getString("name"));
		
		student.setEmail(rs.getString("email"));
		
		student.setMobileNo(rs.getString("mobile"));
		
		student.setDateOfBirth(rs.getDate("dob"));
		
		student.setGender(rs.getString("gender"));
		
		student.setAddress(rs.getString("address"));
		
		return student;
	}


}