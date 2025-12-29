package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
	/*@RequestMapping("/one")
	public String one()
	{
		System.out.println("in one method");
		return "redirect:/enjoy";
	}*/
	@RequestMapping("/one")
	public RedirectView one()
	{
		System.out.println("in one method");
		RedirectView rv=new RedirectView();
		rv.setUrl("enjoy");
		//rv.setUrl("https://www.google.com");
		return rv;
	}
	@RequestMapping("/enjoy")
	public String two()
	{
		System.out.println("in two method");
		return "contact";
	}
	@RequestMapping("/user/{id}/{username}")
	public String getUserDetail(@PathVariable("id") int userId,@PathVariable("username") String username)
	{
		System.out.println(userId+"  "+username);
		return "about";
	}
}
