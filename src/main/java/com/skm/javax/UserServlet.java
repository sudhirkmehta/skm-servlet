package com.skm.javax;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This a simple servlet to create and fetch users on te go.
 * @author sudhirkmehta@gmail.com
 * @version 1.0
 */
public class UserServlet extends HttpServlet {
      
	private static final long serialVersionUID = 1L;
	
	private HashMap<String,String> userMap = new HashMap<String,String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String uid = request.getParameter("uid");
    	StringBuilder resp = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>\n<User>\n");
    	
    	if(uid == null || uid.trim().length() == 0){
    		resp.append("<uid>").append("").append("</uid>\n");
    		resp.append("<name>").append("").append("</name>\n");
    		resp.append("<status>").append("FAILED").append("</status>\n");
    		resp.append("<message>").append("No user id input!").append("</message>\n");
    	}    
    	else if(userMap.containsKey(uid.trim()))
    	{
    		uid = uid.trim();
    		resp.append("<uid>").append(uid).append("</uid>\n");
    		resp.append("<name>").append(userMap.get(uid)).append("</name>\n");
    		resp.append("<status>").append("SUCCESS").append("</status>\n");
    		resp.append("<message>").append("User fetched!").append("</message>\n");
    	}
    	else{
    		uid = uid.trim();
    		resp.append("<uid>").append(uid.trim()).append("</uid>\n");
    		resp.append("<name>").append("").append("</name>\n");
    		resp.append("<status>").append("FAILED").append("</status>\n");
    		resp.append("<message>").append("User Not Found!").append("</message>\n");
    	}    
    	resp.append("</User>");
        response.getWriter().println(resp);
    }
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String uid = request.getParameter("uid");
    	String name = request.getParameter("name");
    	
    	StringBuilder resp = new StringBuilder("<?xml version='1.0' encoding='utf-8'?>\n<User>\n");
    	
    	if(uid == null || uid.trim().length() == 0 || name == null || name.trim().length() == 0){
    		resp.append("<uid>").append(uid).append("</uid>\n");
    		resp.append("<name>").append(name).append("</name>\n");
    		resp.append("<status>").append("FAILED").append("</status>\n");
    		resp.append("<message>").append("No user id/name input!").append("</message>\n");
    	}
    	else{
    		uid = uid.trim();
    		name = name.trim();
    		userMap.put(uid, name);
    		resp.append("<uid>").append(uid).append("</uid>\n");
    		resp.append("<name>").append(name).append("</name>\n");
    		resp.append("<status>").append("SUCCESS").append("</status>\n");
    		resp.append("<message>").append("User Added!").append("</message>\n");
    	}    
    	resp.append("</User>");
        response.getWriter().println(resp);
    }
}