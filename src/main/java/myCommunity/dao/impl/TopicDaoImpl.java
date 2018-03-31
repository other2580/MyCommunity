package myCommunity.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myCommunity.dao.TopicDao;
import myCommunity.entity.Topic;

@SuppressWarnings("unchecked")
@Repository
public class TopicDaoImpl implements TopicDao{

	@Autowired
	private HibernateTemplate db;
	
	@Override
	public List<Topic> findTopicTop6() {
		
		//return (List<Topic>) db.find("from Topic t order by t.updateTime");
		return db.execute(new HibernateCallback<List<Topic>>() {

			public List<Topic> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Topic t order by t.updateTime desc");
				query.setFirstResult(0);
				query.setMaxResults(6);
				System.out.println(query.list().size());
				return query.list();
			}
		});
	}

	@Override
	public List<Topic> findBy1(int fornumId) {
		return (List<Topic>) db.find("from Topic t where t.isBest=1 and t.forum.id=?",fornumId);
	}
	
	@Override
	public List<Topic> findBy0(int fornumId, int pageNum, int pageSize) {
		return db.execute(new HibernateCallback<List<Topic>>() {
			@Override
			public List<Topic> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Topic t where t.isBest=0 and t.forum.id=?");
				query.setInteger(0, fornumId);
				query.setFirstResult((pageNum-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public int findBy0Rows(int fornumId) {
		List<Number> list = (List<Number>) db.find("select count(t.id) from Topic t where t.isBest=0 and t.forum.id=?",fornumId);
		return list.get(0).intValue();
	}
	

	@Override
	public List<Topic> findByTitle(int fornumId, String title, int pageNum, int pageSize) {
		return db.execute(new HibernateCallback<List<Topic>>() {
			@Override
			public List<Topic> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("from Topic t where t.title like :title and t.forum.id =:id");
				query.setString("title", "%"+title+"%");
				query.setInteger("id", fornumId);
				query.setFirstResult((pageNum-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	@Override
	public int findByTitleRows(int fornumId, String title) {
		ArrayList parameters = new ArrayList();
		String hql = "select count(t.id) from Topic t where title like ?";
		parameters.add(0, "%"+title+"%");
		List<Number> list = (List<Number>) db.find(hql, parameters.toArray());
		return list.get(0).intValue();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		TopicDao tdao = ctx.getBean(TopicDao.class);
		List<Topic> num = tdao.findBy1(3);
		System.out.println(num.size()+"  123");
		List<Topic> list = tdao.findByTitle(3, "4", 1, 10);
		System.out.println(list.size()+"  abc");
		
	}

	@Override
	public Topic findById(int id) {
		return (Topic) db.find("from Topic t where t.id=?",id).get(0);
	}
	
	
	
}
