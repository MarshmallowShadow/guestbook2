package com.javaex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import com.javaex.dao.*;
import com.javaex.vo.*;

@WebServlet("/gbc")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		GuestBookDao gDao = new GuestBookDao();
		String action = request.getParameter("action");
		
		if("addList".equals(action)) {
			List<GuestVo> gList = gDao.getList();
			
			request.setAttribute("gList", gList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/addList.jsp");
			rd.forward(request, response);
		}
		else if("deleteForm".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/deleteForm.jsp");
			rd.forward(request, response);
		}
		else if("add".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			GuestVo gVo = new GuestVo(name, password, content);
			
			gDao.insert(gVo);
			
			response.sendRedirect("./gbc?action=addList");
		}
		else if("delete".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
			GuestVo gVo = gDao.getGuest(no);
			String correct = gVo.getPassword();
			
			if(password.equals(correct)) {
				gDao.delete(no);
				response.sendRedirect("./gbc?action=addList");
			} else {
				response.sendRedirect("./gbc?action=deleteForm&no=" + no);
			}
		}
		else {
			System.out.println("unknown action");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
