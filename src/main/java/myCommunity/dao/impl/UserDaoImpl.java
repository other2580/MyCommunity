package myCommunity.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.UserDao;
import myCommunity.entity.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate db;
	
	@Override
	public User checkLogin(String username, String password) {
		String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
		String[] paramName = new String[] { "username", "password" };
		String[] value = new String[] { username, password };
		List<User> list = (List<User>) db.findByNamedParam(hql, paramName, value);
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int addUser(User user) {
		return (int) db.save(user);
	}

	@Override
	public User findById(int id) {
		return db.get(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		db.update(user);
	}

//	@Override
//	public User checkUserName(String username) {
//		List<User> list = (List<User>) db.find("from User u where u.username=?", username);
//		return list.size()>0 ? list.get(0) : null;
//	}

}
