package myCommunity.web.action;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import myCommunity.dao.ForumDao;
import myCommunity.dao.TopicDao;
import myCommunity.entity.Forum;
import myCommunity.entity.Topic;

@Component
@Scope("prototype")
public class ForumAction {
	
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private TopicDao topicDao;
	private List<Forum> forum;
	private List<Topic> topic;
	
	public List<Forum> getForum() {
		return forum;
	}
	
	public List<Topic> getTopic() {
		return topic;
	}

	public void setTopic(List<Topic> topic) {
		this.topic = topic;
	}

	public String getAll(){
		this.forum = forumDao.getAll();
		this.topic = topicDao.findTopicTop6();
		return "index";
	}
	
}
