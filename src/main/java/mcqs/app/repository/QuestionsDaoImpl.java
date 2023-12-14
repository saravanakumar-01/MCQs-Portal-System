package mcqs.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mcqs.app.entities.Course;
import mcqs.app.entities.Questions;

public class QuestionsDaoImpl implements QuestionsDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	

	@Override
	public int insertQuestions(Questions questions) {
		
		String INSERT_QUESTION = "INSERT INTO questions (`course_id`, `question_name`, `opt1`, `opt2`, `opt3`, `opt4`, `correct`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(INSERT_QUESTION, questions.getCourseId(), questions.getQuestionName(), questions.getOpt1(), questions.getOpt2(), questions.getOpt3(), questions.getOpt4(), questions.getCorrect());
	}

	@Override
	public List<Course> getListOfCoursesName() {
		
	    List<Course> courseName = new ArrayList<Course>();
		
		String GET_COURSENAMES = "SELECT * FROM courses";
		
		courseName = jdbcTemplate.query(GET_COURSENAMES, new CourseNameRowMapper());
		
		return courseName;
	}

	@Override
	public List<Questions> getListOfQuestions(int courseId) {
		
        List<Questions> questionsList = new ArrayList<Questions>();
		
		String GET_QUESTIONS = "SELECT * FROM questions WHERE course_id = ?";
		
		questionsList = jdbcTemplate.query(GET_QUESTIONS, new QuestionsRowMapper(), courseId);
		
		return questionsList;
	}

	@Override
	public int deleteQuestions(int questionId) {
		
		String DELETE_COURSES = "CONSTRAINT question_id FOREIGN KEY (question_id) "
				+ "REFERENCES questions(question_id) "
				+ "ON DELETE CASCADE ";
		return jdbcTemplate.update(DELETE_COURSES, questionId);
	}

	
	


}
