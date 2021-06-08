package jp.co.aforce.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Customer;

public class LoginAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
			)throws Exception{
		
		String name="login";
		String value="value";
		Cookie cookie=new Cookie(name, value);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
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