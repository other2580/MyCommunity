package myCommunity.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myCommunity.dao.TopicDao;
import myCommunity.entity.Topic;

@Component
@Scope("prototype")
public class TopicAction {

	@Autowired
	private TopicDao topicDao;
	
	private int id;
	private String title;
	private int pageNum;
	private int total;
	private int rows;
	private String titleForum;
	int pageSize = 6;
	
	
	
	private List<Topic> topic0;
	private List<Topic> topic1;
	private List<Topic> topic2;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public List<Topic> getTopic0() {
		return topic0;
	}

	public void setTopic0(List<Topic> topic0) {
		this.topic0 = topic0;
	}

	public List<Topic> getTopic1() {
		return topic1;
	}

	public void setTopic1(List<Topic> topic1) {
		this.topic1 = topic1;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public List<Topic> getTopic2() {
		return topic2;
	}

	public void setTopic2(List<Topic> topic2) {
		this.topic2 = topic2;
	}
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getTitleForum() {
		return titleForum;
	}

	public String findTopicByTitle() {
		this.total = 0;
		if(title != null && !title.isEmpty()) {
			this.topic2 = topicDao.findByTitle(id, title, pageNum, pageSize);
			this.rows = topicDao.findByTitleRows(id, title);
			this.total = this.rows%this.pageSize==0?this.rows/this.pageSize:this.rows/this.pageSize+1;
			this.titleForum = topic2.get(0).getForum().getName();
		}else {
			this.topic1 = topicDao.findBy1(id);
			this.topic0 = topicDao.findBy0(id, pageNum, pageSize);
			this.rows = topicDao.findBy0Rows(id);
			this.total = this.rows%this.pageSize==0?this.rows/this.pageSize:this.rows/this.pageSize+1;
			this.titleForum = topic1.get(0).getForum().getName();
		}
		return "findTopic";
	}
	
}
