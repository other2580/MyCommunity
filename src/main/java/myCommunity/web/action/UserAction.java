package myCommunity.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import myCommunity.dao.UserDao;
import myCommunity.entity.User;

@SuppressWarnings("unused")
@Component
@Scope("prototype")
public class UserAction implements ServletRequestAware{
	
	@Autowired
	private UserDao userDao;
	
	private int id;
	private String username;
	private String password;
	private String message;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String checklogin(){
		User loginUser = userDao.checkLogin(username,password);
		System.out.println(loginUser.getUsername()+"  +  "+loginUser.getNickname());
		if(loginUser!=null) {
			request.getSession().setAttribute("loginUser", loginUser);
			return "success";
		}else {
			this.message = "用户名或密码错误";
			return "login";
		}
	}
	
	public String login() {
		return "login";
	}
	
	public String register() {
		return "register";
	}
	
	public String updateuser() {
		return "updateuser";
	}
	
	public String updateEmail() {
		return "updateEmail";
	}
	
	public String registerUser() {
		User u = new User();
		System.out.println(this.user.getEmail());
		this.user.setGrade(100);
		this.user.setRoleId(1);
		this.user.setStatus(1);
		return "success";
	}
	
	public String outs() {
		HttpServletRequest req = ServletActionContext.getRequest();
		req.getSession().invalidate();
		return "login";
	}
	
	
	public String updateU() {
		User u = (User) request.getSession().getAttribute("loginUser");
		user.setId(u.getId());
		user.setRoleId(u.getRoleId());
		user.setStatus(u.getStatus());
		userDao.updateUser(user);
		return "login";
	}

	
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
