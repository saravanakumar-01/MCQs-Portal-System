package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setFullName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setMobileNo(rs.getString("mobile"));
		user.setDateOfBirth(rs.getDate("dob"));
		user.setPwdHash(rs.getString("password_hash"));
		user.setPwdSalt(rs.getString("password_salt"));
		user.setAddress(rs.getString("address"));
		user.setGender(rs.getString("gender"));
		user.setRole(rs.getInt("role"));
		user.setStatus(rs.getBoolean("status"));
	
		return user;
	}

}
