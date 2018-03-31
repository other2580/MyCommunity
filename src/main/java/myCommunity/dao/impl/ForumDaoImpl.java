package myCommunity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.ForumDao;
import myCommunity.entity.Forum;

@SuppressWarnings("unchecked")
@Repository
public class ForumDaoImpl implements ForumDao{

	@Autowired
	private HibernateTemplate db;
	
	@Override
	public List<Forum> getAll() {
		return (List<Forum>) db.find("select distinct f from Forum f join fetch f.forum");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		ForumDao forumDao = ctx.getBean(ForumDao.class);
		for(Forum c : forumDao.getAll()) {
			if(c.getParentId() == null) {
				System.out.println(c.getName());
				for(Forum f : c.getForum()) {
					System.out.println("\t"+f.getName());
				}
			}
			
		}
	}
}
