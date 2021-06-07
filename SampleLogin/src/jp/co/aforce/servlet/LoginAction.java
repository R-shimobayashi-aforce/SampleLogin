package jp.co.aforce.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Customer;

@WebServlet(urlPatterns= {"/web/LoginAction/"})
public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
			)throws Exception{
		
		HttpSession session=request.getSession();
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		jp.co.aforce.DAO.CustomerDAO dao=new jp.co.aforce.DAO.CustomerDAO();
		Customer customer=dao.search(login, password);
		
		if(customer!=null) {
			session.setAttribute("customer", customer);
			return "login-out.jsp";
		}
		
		return "login-error.jsp";
	}
	
}