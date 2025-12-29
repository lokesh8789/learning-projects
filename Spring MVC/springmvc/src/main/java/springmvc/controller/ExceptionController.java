package springmvc.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
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
	}
}
