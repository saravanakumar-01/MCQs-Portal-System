package mcqs.app.repository;

import java.util.List;

import mcqs.app.entities.Accounts;
import mcqs.app.entities.Answers;
import mcqs.app.entities.Attendance;
import mcqs.app.entities.CorrectAnswer;
import mcqs.app.entities.Course;
import mcqs.app.entities.Exams;
import mcqs.app.entities.Questions;

public interface ExamsDao {
	
	List<Course> getListOfCourses(int id);
	
	List<Questions> getListOfQuestions(int courseId);
	
	Course getCourseTime(int courseId);
	
	int insertAnswers(Answers answers);
	
	CorrectAnswer getCorrectAnswerById(int questionId);
	
	int insertAttendance(Attendance attendance);
	
	List<Answers> getAllAnswers();
	
	int getMarkStatusCount(int id, int courseId);
	
	List<Answers> getAllCorrectAnswers(int id, int courseId);
	
	int insertResult(Exams exams);
	
	Exams getExamResult(int id,int courseId);
	
	List<Answers> viewAllAnswers(int id,int courseId);
	
	
	
	

}
