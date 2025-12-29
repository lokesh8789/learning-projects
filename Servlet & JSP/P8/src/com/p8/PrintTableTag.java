package com.p8;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTableTag extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int number;
	public String color;
	public void setColor(String color) {
		this.color = color;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		try {
			out.println("<div style='color:"+color+"'>");
			out.println("<br>");
			for(int i=1;i<=10;i++)
			{
				out.println((i*number)+"<br>");
			}
			out.println("</div>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
