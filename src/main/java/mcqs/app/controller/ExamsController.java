package mcqs.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


import mcqs.app.entities.Answers;
import mcqs.app.entities.Attendance;
import mcqs.app.entities.CorrectAnswer;
import mcqs.app.entities.Course;
import mcqs.app.entities.Exams;
import mcqs.app.entities.Questions;
import mcqs.app.entities.StartTime;
import mcqs.app.entities.User;
import mcqs.app.repository.CourseDao;
import mcqs.app.repository.ExamsDao;

@Controller
public class ExamsController {
	
	@Autowired
	ExamsDao examsDao;
	@Autowired
	CourseDao courseDao;
	
	
	
	@GetMapping("/studentExams")
	public String studentCourses(@ModelAttribute Exams exam, Model model, HttpServletRequest request) {
		
		System.out.println(exam);
		HttpSession session = request.getSession();
		User student = (User) session.getAttribute("userData"); 
		List<Course> exams = examsDao.getListOfCourses(student.getId());
		
		model.addAttribute("listOfExams", exams);
		
		return "student_takeexam";
	}
	
	@GetMapping("/studentQuestions")
	public String viewQuestions(@RequestParam("startTime") String startTime, @RequestParam("courseId") int courseId, 
								Model model, HttpServletRequest request) {
		
		StartTime start = new StartTime(startTime);
		
		HttpSession session = request.getSession();
		
		User studentId = (User) session.getAttribute("userData");
		
		session.setAttribute("startTime", start);
		
		session.setAttribute("CourseId", courseId);
		
		List<Questions> questions = examsDao.getListOfQuestions(courseId);
		
		Course courseTime = examsDao.getCourseTime(courseId);
		
		//session.setAttribute("startTime",start);
		
		model.addAttribute("listOfQuestions", questions);
		
		model.addAttribute("getTime",courseTime);
		
		System.out.println(questions);
		
		return "student_exams";
		
	}
		@GetMapping("/examSubmit")
		public String submitTest(Model model,
				HttpServletRequest request,
				@RequestParam("examDate") String examDate,
				@RequestParam("endTime") String endTime,
				@RequestParam Map<String, String> formData, 
				@RequestParam("courseId") int courseId,
				@RequestParam("id") int id) {
			HttpSession session = request.getSession();
			User studentId = (User) session.getAttribute("userData");
			List<Course> courses = examsDao.getListOfCourses(id);
			List<Questions> questions = examsDao.getListOfQuestions(courseId);
	        // Iterate over the map to process the submitted data
			int result = 0, result2 = 0;
			Attendance attendance = new Attendance();
			attendance = new Attendance(id,courseId, true);
			result2 = examsDao.insertAttendance(attendance);
			
			if(result2 != 1) {
				model.addAttribute("message","This test was already taken by you");
			}
			List<Answers> answers = examsDao.getAllAnswers();
			
			model.addAttribute("listOfAnswers",answers);
			
			//CorrectAnswer getCorrectAnswerCount = examsDao.getMarkStatusCount(studentId.getId(), courseId);
			int getCorrectAnswerCount = examsDao.getMarkStatusCount(id, courseId);
	        for (Map.Entry<String, String> entry : formData.entrySet()) {
	        	
	        	String key = entry.getKey();
	        	if(key.startsWith("ques")) {
	        		
	        		String questionId = key; // Extract question number from the parameter name
	 	            String answer = entry.getValue();
	 	            
	 	            Answers a = new Answers();
	 	            
	 	            
	 	            // questionId = "ques1"
	 	            questionId = questionId.substring(4);
	 	            int newQuestionId =Integer.parseInt(questionId);
	 	            
	 	            CorrectAnswer correctAnswer = examsDao.getCorrectAnswerById(newQuestionId);
	 	            
	 	            boolean sts1 = false;
	 	            if(answer.equals(correctAnswer.getCorrectAnswer())) {
	 	            	sts1=true;
	 	            }
	 	     
	 	            a = new Answers(newQuestionId, id, 
	 	            		courseId, questionId, answer,
	 	            		correctAnswer.getCorrectAnswer(), sts1);
	 	         // Process the data as needed
	 	            
	 	           result = examsDao.insertAnswers(a);
	 	            
	 	            System.out.println(a);  
	 	            
	        		
	        	}else {
	        		
	        	}
	        }
	        List<Answers> answers1 = examsDao.getAllCorrectAnswers(id, courseId);
	        Course courseTime = examsDao.getCourseTime(courseId);
	        double obtainedMarks = 0;
		 	
		 	obtainedMarks = (courseTime.getTotalMarks()/questions.size())*answers1.size();
		 	
		 	System.out.println(questions.size());
		 	System.out.println(answers1.size());
		 	System.out.println("The scored mark is : "+obtainedMarks);
		 	
		 	 //List<Exams> exams = new ArrayList<Exams>();
		 	
			  
			  StartTime start1 = (StartTime) session.getAttribute("startTime");
			  
			  
			  
			  model.addAttribute("getTime",courseTime);
			  
			  	boolean sts2 = false;
			 	if(obtainedMarks >= (courseTime.getTotalMarks()/2)) {
			 		sts2 = true;
			 	}
			  
			  Exams exams = new Exams(courseId,id,courseTime.getCourseName(),examDate,courseTime.getTotalMarks(),
					  obtainedMarks, start1.getStartTime(), endTime, courseTime.getTime(), sts2);
			  
			  int result3 = examsDao.insertResult(exams);
			  if(result == 1) {
	        	return "student_submit";
	        }else {
	        	return "failure";
	        }
	        
	  
	            
	        
	    }
		
	
	@GetMapping("/studentResults")
	public String viewResults(Model model, HttpServletRequest request
			) {
		
		HttpSession session = request.getSession();
		User studentId = (User) session.getAttribute("userData");
		
		int id= studentId.getId();	
		
		int courseid = (int) session.getAttribute("CourseId");
		
		Exams examResult = examsDao.getExamResult(id, courseid);
		
		System.out.println(examResult);
		
		model.addAttribute("getResult",examResult);
		
		return "student_result";
	}
	
	@GetMapping("/studentViewAnswers")
	public String viewAnswers(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User studentId = (User) session.getAttribute("userData");
		
		int id= studentId.getId();	
		
		int courseid = (int) session.getAttribute("CourseId");
		
		List<Answers> answerView = examsDao.viewAllAnswers(id, courseid);
		
		model.addAttribute("getViewAnswers",answerView);
		
		return "student_view_answers";
	}
	
	

}
