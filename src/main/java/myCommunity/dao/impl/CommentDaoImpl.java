package myCommunity.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.CommentDao;
import myCommunity.dao.ForumDao;
import myCommunity.entity.Comment;
import myCommunity.entity.Forum;

@SuppressWarnings("unchecked")
@Repository
public class CommentDaoImpl implements CommentDao{

	@Autowired
	private HibernateTemplate db;
	
	@Override
	public List<Comment> fectAll(int referenceId, int pageNum, int pageSize) {
		//pagenum≥ı º÷µ=1
		//pageSize=5
		//1
		//pagenum-1 * pagesize 
		//pageSize-1
		//2
		//(pagenum-1 * pagesize)-1
		//pageSize
		return db.execute(new HibernateCallback<List<Comment>>() {
			@Override
			public List<Comment> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Comment c where c.topic.id=?");
				query.setInteger(0, referenceId);
				if(pageNum==1) {
					query.setFirstResult((pageNum-1)*pageSize);
					query.setMaxResults(pageSize-1);
				} else {
					query.setFirstResult(((pageNum-1) * pageSize)-1);
					query.setMaxResults(pageSize);
				}
				return query.list();
			}
		});
	}

	@Override
	public int fectAllRows(int referenceId) {
		List<Number> list = (List<Number>) db.find("select count(c.id) from Comment c where c.topic.id=?",referenceId);
		return list.get(0).intValue();
	}

	@Override
	public int addComment(Comment com) {
		return (int) db.save(com);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		CommentDao commentDao = ctx.getBean(CommentDao.class);
		for(Comment c : commentDao.fectAll(1, 1, 30)) {
			System.out.println(c.getContent()+"  "+c.getTopic().getId()+"  "+c.getId());
		}
		System.out.println(17%5);
	}

}
