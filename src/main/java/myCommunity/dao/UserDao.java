package myCommunity.dao;

import myCommunity.entity.User;

public interface UserDao {

	User checkLogin(String username, String password);
	
	int addUser(User user);
	
	//User checkUserName(String username);
	
	User findById(int id);
	
	void updateUser(User user);
	
}
