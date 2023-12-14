package mcqs.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mcqs.app.entities.Accounts;
import mcqs.app.repository.AccountsDao;

@Controller
public class AccountsController {
	
	@Autowired
	AccountsDao accountsDao;
	
	@GetMapping("/adminAccounts")
	public String adminAccounts(Model model) {
		
		List<Accounts> accounts = accountsDao.getAllResults();
		
		model.addAttribute("listOfStudentsResults",accounts);
		
		System.out.println(accounts);
		
		return "admin_accounts";
	}
}
