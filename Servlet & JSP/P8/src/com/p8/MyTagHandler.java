package com.p8;

import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out=pageContext.getOut();
			out.println("<h1> hello custom tag </h1>");
			out.println(new Date().toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
}
