package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model)
	{
		System.out.println("in home method");
		model.addAttribute("name","lokesh");
		model.addAttribute("id",254);
		List<String> f=new ArrayList<String>();
		f.add("wow");
		f.add("gzb");
		f.add("bs");
		model.addAttribute("list",f);
		return "index";
	}
	@RequestMapping("/about")
	public String about() {
		System.out.println("in about method");
		return "about";
	}
	@RequestMapping("/help")
	public ModelAndView help()
	{
		System.out.println("in help method");
		ModelAndView m=new ModelAndView();
		m.addObject("name","lokesh");
		m.addObject("roll",24);
		LocalDateTime now=LocalDateTime.now();
		m.addObject("time",now);
		List<Integer> lis= new ArrayList<Integer>();
		lis.add(24);
		lis.add(87);
		lis.add(56);
		m.addObject("l",lis);
		//set view name
		m.setViewName("help");
		return m;
	}
}
