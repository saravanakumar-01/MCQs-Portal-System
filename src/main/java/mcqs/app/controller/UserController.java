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

import mcqs.app.entities.User;
import mcqs.app.repository.UserDao;
import mcqs.app.utils.Utils;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome";
	}
	
	@GetMapping("/user_login")
	public String openLoginAdminpage() {
		return "user_login";
	}
	
	@GetMapping("/user_register")
	public String openRegisterAdminpage() {
		return "user_register";
	}
	
	
	@PostMapping("/register")
	public String register(
			@ModelAttribute User user,
			Model model) {
		
		
		if(user.getRole()==3) {
			user.setStatus(true);
		}

		System.out.println(user);
		
		int result = userDao.insertUser(user);
		
		if(result == 1) {
			model.addAttribute("message", "Registration Successfull.<br/> Please Log In to continue");
			return "user_login";
			
		} else {
			model.addAttribute("message", "Could not register.<br/> Please try again");
			return "user_register";
		}
	}
	
	
	@PostMapping("/login")
	public String handleLoginUserRequest(@RequestParam("username") String emailId,
			@RequestParam("password") String password, Model model, HttpServletRequest request) {
		
		User userData = userDao.getUserData(emailId);
		
		String newPwdHash = Utils.generatePasswordHash(userData.getPwdSalt() + password);
		String pwdHashDb = userData.getPwdHash();
		
		System.out.println("Password Salt : "+newPwdHash);
		System.out.println("Password Hash : "+pwdHashDb);
		
		if(newPwdHash.equals(pwdHashDb)) {
			HttpSession session = request.getSession();
			session.setAttribute("userData", userData);
			if(!userData.isStatus()) {
				System.out.println("unapproved");
				return "user_login";
			}
			int role = userData.getRole();
			if(role==1) {
				return "superadmin_dashboard";
			} else if (role==2) {			
				
				return "admin_panel";
				
			} else {
				return "student_panel";
			}				
			
			
		}else {
			model.addAttribute("message", "Invalid login credentials");
			return "user_login";
		}
		
	}
	
	@GetMapping("/adminProfile")
	public String openProfile(HttpSession session) {
		User admin = (User) session.getAttribute("userData");
		User updatedAdmin = userDao.getAdminProfile(admin.getEmail());
		System.out.println(admin);
		session.setAttribute("AdminProfile", admin);
		session.setAttribute("updatedAdmin", updatedAdmin);
		return "admin_profile";
	}
	
	@GetMapping("/superadminLogout")
	public String processSuperadminLogout(HttpSession session, 
			Model attr) {

		System.out.println(session.getAttribute("user"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "user_login";
	}
	
	@GetMapping("/adminLogout")
	public String processadminLogout(HttpSession session, 
			Model attr) {

		System.out.println(session.getAttribute("user"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "user_login";
	}
	
	@GetMapping("/studentLogout")
	public String processstudentLogout(HttpSession session, 
			Model attr) {

		System.out.println(session.getAttribute("user"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "user_login";
	}
	
	@GetMapping("updateAdmin")
	public String openUpdatePage(@RequestParam("email") String email, Model model) {
		
		User admin = userDao.getAdminProfile(email);
		System.out.println(admin);
		model.addAttribute("admin",admin);
		System.out.println(admin);
		return "admin_update";
	}
    
	@GetMapping("/admin_update")
	public String handleUpdatePage(
			@ModelAttribute User admin,HttpServletRequest request) {

		System.out.println(admin);
		
		HttpSession session=request.getSession();
		int result = userDao.updateAdmin(admin);
		session.setAttribute("adminProfile", new User());
		if(result==1) {
			return "redirect:/adminProfile";
		}else {
			return "admin_profile";
		}
		
	}
	
	@GetMapping("/displayAdmins")
	public String getAllAdminList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		List<User> allAdmins = userDao.getAllAdmin();
		System.out.println(allAdmins);
		session.setAttribute("allAdminList", allAdmins);
		return "view_all_admin";
	}
	
	@GetMapping("/revokeAccess")
	public String updateAdminRevokeAccess(@RequestParam("email") String email) {
	
		int result = userDao.revokeAccessForAdmin(email);
		return result == 1?"superadmin_dashboard":"failure";
	}
	
	@GetMapping("/grantAccess")
	public String updateAdminGrantAccess(@RequestParam("email") String email) {
	
		int result = userDao.grantAccessForAdmin(email);
		return result == 1?"superadmin_dashboard":"failure";
	}
	
	@GetMapping("/studentProfile")
	public String sopenStudentProfile(HttpSession session) {
		User student = (User) session.getAttribute("userData");
		User updatedStudent = userDao.getStudentProfile(student.getEmail());
		session.setAttribute("StudentProfile", student);
		session.setAttribute("updatedStudent", updatedStudent);
		return "student_profile";
		
	}
	
	@GetMapping("updateStudent")
	public String openStudentUpdatePage(@RequestParam("email") String email, Model model) {
		
		User student = userDao.getStudentProfile(email);
		System.out.println(student);
		model.addAttribute("user",student);
		System.out.println(student);
		return "student_update";
	}
	
	@GetMapping("/student_update")
	public String handleStudentUpdatePage(
			@ModelAttribute User student,HttpServletRequest request) {

		System.out.println(student);
		HttpSession session=request.getSession();
		int result = userDao.updateStudent(student);
		session.setAttribute("studentProfile", new User());
		if(result==1) {
			return "redirect:/studentProfile";
		}else {
			return "student_profile";
		}
		
	}
	
	@GetMapping("adminHomePage")
	public String openAdminHomePage() {
		return "user_login";
	}
	
	@GetMapping("studentHomePage")
	public String openStudentHomePage() {
		return "student_panel";
	}
	
	@GetMapping("adminpanel")
	public String openAdminPanel() {
		return "admin_panel";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
