package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.User;

public class AdminProfileRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User admin = new User();
		
		admin.setId(rs.getInt("id"));
		
		admin.setFullName(rs.getString("name"));
		
		admin.setEmail(rs.getString("email"));
		
		admin.setMobileNo(rs.getString("mobile"));
		
		admin.setDateOfBirth(rs.getDate("dob"));
		
		admin.setGender(rs.getString("gender"));
		
		admin.setAddress(rs.getString("address"));
		
//		admin.setPassword(rs.getString("password"));
		
		return admin;
	}
	
	

}
