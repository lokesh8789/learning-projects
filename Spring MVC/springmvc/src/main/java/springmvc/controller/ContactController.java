package springmvc.controller;

//import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	@Autowired
	private UserService userService;
	@ModelAttribute
	public void common(Model m)
	{
		m.addAttribute("Header","wow");
		m.addAttribute("Desc","good");
	}
	@RequestMapping("/contact")
	public String showForm()
	{
		System.out.println("in contact method");
		return "contact";
	}

	/*
	 * @RequestMapping(path="/processform",method=RequestMethod.POST) public String
	 * handleForm(HttpServletRequest req) { String email=req.getParameter("email");
	 * 
	 * System.out.println(email); return ""; }
	 */
	/*@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam(name="email", required=false) String email, @RequestParam("userName") String name,
			@RequestParam("password") String password,Model m) 
	{
		System.out.println(email);
		System.out.println(name);
		System.out.println(password);
		m.addAttribute("email",email);
		m.addAttribute("name",name);
		m.addAttribute("password",password);
		
		return "success";
	}*/
	/*@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@RequestParam(name="email", required=false) String email, @RequestParam("userName") String name,
			@RequestParam("password") String password,Model m) 
	{
		User user=new User(email,name,password);
		m.addAttribute("user",user);
		System.out.println(user);
		
		return "success";
	}*/
	
	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user,Model m) 
	{
		System.out.println(user);
		if(user.getUserName().isBlank())
		{
			return "redirect:/contact";
		}
		int id = this.userService.createUser(user);
		m.addAttribute("msg","User created with id:- "+id);
		return "success";
	}
	/*
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandlerNumberFormat(Model m)
	{
		m.addAttribute("msg","Number format exception has occurred");
		return "exceptionPage";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NullPointerException.class)
	public String exceptionHandlerNullFormat(Model m)
	{
		m.addAttribute("msg","Null exception has occurred");
		return "exceptionPage";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ArrayIndexOutOfBoundsException.class,IOException.class,ArithmeticException.class})
	public String exceptionHandlerMultiple(Model m)
	{
		m.addAttribute("msg","exception has occurred");
		return "exceptionPage";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Model m)
	{
		m.addAttribute("msg","exception has been occurred");
		return "exceptionPage";
	}*/
}
