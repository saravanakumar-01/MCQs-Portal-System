package mcqs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mcqs.app.entities.Course;
import mcqs.app.entities.Questions;
import mcqs.app.repository.CourseDao;
import mcqs.app.repository.QuestionsDao;

@Controller
public class QuestionsController {
	
	@Autowired
	QuestionsDao questionsDao;
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/adminQuestions")
	public String adminQuestions(Model model) {
		
		List<Course> courses = courseDao.getListOfCourses();
		
		model.addAttribute("listOfCourses", courses);
		
		System.out.println(courses);
		
		return "admin_questions"; 
	}
	
	@PostMapping("/addQuestions")
	public String addQuestions(@ModelAttribute Questions questions, Model model) {
		
		System.out.println(questions);
		
		int result = questionsDao.insertQuestions(questions);
		
		if(result==0) {

			return "failure";
		}
		return "redirect:adminQuestions";
	}
	
	@GetMapping("/viewQuestions")
	public String viewQuestions(@RequestParam("courseId")int courseId, Model model) {
		
		List<Questions> questions = questionsDao.getListOfQuestions(courseId);
		
		model.addAttribute("listOfQuestions", questions);
		
		System.out.println(questions);
		
		return "questions_display1";
		
	}
	
	@GetMapping("/deleteQuestions")
	public String deleteQuestions(@RequestParam("id") int id, Model model) {
		
		int result = questionsDao.deleteQuestions(id);
		
		if(result == 0) {
			return "failure";
		}else {
			return "questions_display1";
		}
		
	}

}
