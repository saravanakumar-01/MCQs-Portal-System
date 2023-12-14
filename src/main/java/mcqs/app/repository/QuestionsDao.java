package mcqs.app.repository;

import java.util.List;

import mcqs.app.entities.Course;
import mcqs.app.entities.Questions;

public interface QuestionsDao {
	
	int insertQuestions(Questions questions);
	
	List<Course> getListOfCoursesName();
	
	List<Questions> getListOfQuestions(int courseid);
	
	int deleteQuestions(int questionId);

}
