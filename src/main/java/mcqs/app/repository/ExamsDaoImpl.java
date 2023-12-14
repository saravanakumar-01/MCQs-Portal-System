package mcqs.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import mcqs.app.entities.Answers;
import mcqs.app.entities.Attendance;
import mcqs.app.entities.CorrectAnswer;
import mcqs.app.entities.Course;
import mcqs.app.entities.Exams;
import mcqs.app.entities.Questions;

public class ExamsDaoImpl implements ExamsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Override
	public List<Course> getListOfCourses(int id) {
		
	    List<Course> examName = new ArrayList<Course>();
		
		String GET_COURSENAMES = "SELECT * FROM courses"
				+ " WHERE course_id NOT IN ("
				+ " SELECT course_id"
				+ " FROM attendance"
				+ " WHERE is_attended = true AND student_id = ?"
				+ " )";
		
		examName = jdbcTemplate.query(GET_COURSENAMES, new CourseRowMapper(), id);
		
		return examName;
	}

	@Override
	public List<Questions> getListOfQuestions(int courseId) {
		
		List<Questions> questionsList = new ArrayList<Questions>();
		
		String GET_QUESTIONS = "SELECT * FROM questions WHERE course_id=?";
		
		questionsList = jdbcTemplate.query(GET_QUESTIONS, new QuestionsRowMapper(), courseId);
		
		return questionsList;
	}

	@Override
	public Course getCourseTime(int courseId) {
		
		Course courseTime = new Course();
		
		String GET_TIME = "SELECT * FROM courses WHERE course_id=?";
		
		courseTime =  jdbcTemplate.queryForObject(GET_TIME, new CourseRowMapper(), courseId);
		
		return courseTime;
	}

	@Override
	public CorrectAnswer getCorrectAnswerById(int questionId) {
		
		String GET_CORRECTANSWER = "SELECT correct FROM questions WHERE question_id = ?";
		
		return jdbcTemplate.queryForObject(GET_CORRECTANSWER, new AnswersRowMapper(),questionId);
		
	}

	@Override
	public int insertAnswers(Answers answers) {
		
		String INSERT_ANSWERS = "INSERT INTO answers (`question_id`, `question`, `answer`, `correct_answer`, `status`, `course_id`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(INSERT_ANSWERS, answers.getQuestionId(), answers.getQuestion(), answers.getAnswer(), answers.getCorrectAnswer(), answers.getStatus(), answers.getCourseId(), answers.getId());
		
	}

	@Override
	public int insertAttendance(Attendance attendance) {
		
		String INSERT_ATTENDANCE = "INSERT INTO attendance (`student_id`, `course_id`, `is_attended`) VALUES (?, ?, ?)";
		return jdbcTemplate.update(INSERT_ATTENDANCE, attendance.getId(), attendance.getCourseId(), attendance.isAttended());
	}

	@Override
	public int getMarkStatusCount(int id, int courseId) {
		String GET_MARK_STATUS = "Select count(*) as correctAnswerCount from answers where (id = ? AND course_id = ?) AND status = true";
		return jdbcTemplate.queryForObject(GET_MARK_STATUS, new statusRowMapper(), id, courseId);
	}

	@Override
	public List<Answers> getAllAnswers() {
		
		String GET_ALL_ANSWERS = "SELECT * FROM answers";
		return jdbcTemplate.query(GET_ALL_ANSWERS, new AllAnswersRowMapper());
	}

	@Override
	public List<Answers> getAllCorrectAnswers(int id, int courseId) {
		
		String GET_ALL_CORRECTANSWERS = "Select * from answers where (id = ? AND course_id = ?) AND status = true";
		return jdbcTemplate.query(GET_ALL_CORRECTANSWERS, new AllCorrectRowMapper(), id, courseId);
	}
	
	

	@Override
	public int insertResult(Exams exams) {
		
		String INSERT_RESULT = "INSERT INTO exams (`id`, `course_id`, `total_marks`, `obt_marks`, `start_time`, `end_time`, `exam_time`, `status`, `date`, `course_name`) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(INSERT_RESULT,exams.getUserId(), exams.getCourseId(), exams.getTotalMarks(), 
				                                 exams.getObtMarks(), exams.getStartTime(), exams.getEndTime(),
				                                 exams.getExamTime(), exams.isStatus(), exams.getExamDate(), exams.getExamCourse());
	}

	@Override
	public Exams getExamResult(int id, int courseId) {
		
		Exams resultData = new Exams();
		
		String GET_RESULT = "SELECT * FROM exams WHERE id=? AND course_id=?";
		resultData = jdbcTemplate.queryForObject(GET_RESULT, new ExamsRowMapper(), id, courseId);
		return resultData;
	}

	@Override
	public List<Answers> viewAllAnswers(int id, int courseId) {
		
		String GET_VIEW_ANSWERS = "SELECT answer, correct_answer from answers "
				+"WHERE id=? AND course_id=? ";
		return jdbcTemplate.query(GET_VIEW_ANSWERS, new AnswerCorrectAnswerRowMapper(), id, courseId);
	}



	
	
	
	
	


	
}
