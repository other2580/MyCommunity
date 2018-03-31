package myCommunity.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import myCommunity.entity.User;

public class SecurityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		ActionContext ctx = ai.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		User loginUser = (User)session.get("loginUser");
		if(loginUser!=null) {
			return ai.invoke();
		}else {
			return "login";
		}
	}

}
