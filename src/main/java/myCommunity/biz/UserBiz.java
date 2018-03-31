package myCommunity.biz;

import myCommunity.entity.User;

public interface UserBiz {

	User checkLogin(String username, String password);
	
	int addUser(User user);
	
	//User checkUserName(String username);
	
}
