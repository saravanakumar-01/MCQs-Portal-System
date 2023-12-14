package mcqs.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mcqs.app.entities.Accounts;

public class AccountsDaoImpl implements AccountsDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public List<Accounts> getAllResults() {
		
		String GET_STUDENT_RESULTS = "SELECT "
				+ "e.course_name, "
				+ "e.obt_marks, "
				+ "e.status, "
				+ "e.date, "
				+ "u.name, "
				+ "u.email "
				+ "FROM "
				+ "exams e "
				+ "JOIN "
				+ "user u ON e.id = u.id ";
		return jdbcTemplate.query(GET_STUDENT_RESULTS, new AccountsRowMapper());
	}
}
