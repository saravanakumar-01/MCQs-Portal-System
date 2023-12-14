package mcqs.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mcqs.app.entities.Accounts;

public class AccountsRowMapper implements RowMapper<Accounts>{

	@Override
	public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Accounts accounts = new Accounts();
		accounts.setCourseName(rs.getString("course_name"));
		accounts.setDate(rs.getString("date"));
		accounts.setEmail(rs.getString("email"));
		accounts.setName(rs.getString("name"));
		accounts.setMarks(rs.getDouble("obt_marks"));
		accounts.setStatus(rs.getBoolean("status"));
		return accounts;
	}

}
