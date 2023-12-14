package mcqs.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mcqs.app.entities.Course;
import mcqs.app.entities.User;
import mcqs.app.repository.CourseDao;

@Controller
public class CourseController {
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/adminCourses")
	public String adminCourses(Model model) {
	
		return "admin_course"; 
	}
	
	@GetMapping("/addCourses")
	public String addCourses(Model model,@ModelAttribute Course course,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int result = courseDao.insertCourse(course);
		
		//model.addAttribute("Courses",course);
		
		if(result==1) {	
			return "admin_course";
		}else {
			model.addAttribute("message", "Courses not added successfully");
			return "admin_course";
		}	
	}
	
	@GetMapping("/allCourses")
	public String allCourses(Model model, HttpServletRequest request) {
			
		    HttpSession session = request.getSession();
		    
		    session.getAttribute("userData");
			
			List<Course> courses = courseDao.getListOfCourses();
			
			model.addAttribute("listOfCourses", courses);
			
			System.out.println(courses);
			
			return "admin_allcourses";
	}
	
	@GetMapping("/deleteCourses")
	public String deleteCourses(@RequestParam("id") int id, Model model) {
		
		
		
		int result = courseDao.deleteCourse(id);
		
		List<Course> courses = courseDao.getListOfCourses();
		model.addAttribute("listOfCourses", courses);
		
		if(result == 0) {
			return "failure";
		}else {
			return "admin_allcourses";
		}
		
	}

	
	
	
	

}
