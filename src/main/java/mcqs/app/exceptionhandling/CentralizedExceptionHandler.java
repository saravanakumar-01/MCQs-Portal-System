package mcqs.app.exceptionhandling;

import java.io.IOException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler { 
	
	@ExceptionHandler(value=IndexOutOfBoundsException.class)
	public String itOfBoundsHandler(Model model) {
	model.addAttribute("errormessage","The content you are trying to access is empty!");
	return "exception_handling_page";
	}
	
	@ExceptionHandler(value=NullPointerException.class)
	public String nPEHandler(Model model) {
		model.addAttribute("errormessage","Null_Pointer_Exception------PROVIDED DATA SHOULD NOT BE NULL");
		return "exception_handling_page";
		}
	@ExceptionHandler(value=ArithmeticException.class)
	public String arthematicExcptHandler(Model model) {
		model.addAttribute("errormessage","Arithmetic_Exception------Check The Data Provided");
		return "exception_handling_page";
		}
	@ExceptionHandler(value=IOException.class)
	public String iOExcptHandler(Model model) {
		model.addAttribute("errormessage","IO_Exception------Provided Crt Data");
		return "exception_handling_page";
		}
	
	@ExceptionHandler(value=DuplicateKeyException.class)
	public String duplicate(Model model) {
		model.addAttribute("errormessage","This action is not Possible because, Action already performed!");
		return "exception_handling_page";
		}
	
	@ExceptionHandler(value=EmptyResultDataAccessException.class)
	public String emptyAccess(Model model) {
		model.addAttribute("errormessage","Required Data Not Found!");
		return "exception_handling_page";
		}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public String dataNotFoundExcptHandler(Model model) {
		model.addAttribute("errormessage","User_not_found_Exception------User Detail Is Not Present");
		return "exception_handling_page";
		}
	
	
}