package listingelements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import entity.user;
import model.UsersModel;

@WebServlet("/operation") //if u put only slash then the error page will not be shown up
public class operationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/project")
	private DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		page=page.toLowerCase();
		switch(page) {
		case "listusers":
			listusers(request,response);
			break;
		case "addusers":
			addusersformloader(request,response);
			break;
		case "updateuser":
			updateuserformloader(request,response);
			break;
		case "deleteuser":
			deleteuser(Integer.parseInt(request.getParameter("usersID")));
			listusers(request,response);
			break;
		default:
			errorpage(request,response);
			
		}
	}
	private void deleteuser(int usersID) {
		new UsersModel().deleteuser(dataSource,usersID);
		return;
	}
	private void updateuserformloader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title","update user");
		try {
			request.getRequestDispatcher("updateuser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("form");
		operation=operation.toLowerCase();
		switch(operation) {
		case "adduseroperation":
			user newUser=new user(request.getParameter("username"),request.getParameter("email"));
			adduseroperation(newUser);
			listusers(request,response);
			break;
		case "updateuseroperation":
		    user updateduser=new user(Integer.parseInt(request.getParameter("usersId")),request.getParameter("username") , request.getParameter("email"));
			updateuseroperation(dataSource,updateduser);
			listusers(request,response);
		    break;
		default:
			errorpage(request,response);
		}
	}
	
	
	
	private void updateuseroperation(DataSource dataSource2, user updateduser) {
		new UsersModel().updateuser(dataSource,updateduser);
		return;
	}
	private void adduseroperation(user newUser) {
	    new UsersModel().adduser(dataSource, newUser);
		return;
	}
	public void listusers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<user> listUsers=new ArrayList<>();
		listUsers=new UsersModel().listUsers(dataSource);
		request.setAttribute("listUsers",listUsers);
		request.setAttribute("title","List of Users");
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
	}
	public void addusersformloader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Add Users");
		request.getRequestDispatcher("addusers.jsp").forward(request, response);
	}
	public void errorpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title","errorpage");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	}


