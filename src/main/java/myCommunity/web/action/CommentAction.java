package myCommunity.web.action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import myCommunity.dao.CommentDao;
import myCommunity.dao.TopicDao;
import myCommunity.entity.Comment;
import myCommunity.entity.Topic;
import myCommunity.entity.User;

@Component
@Scope("prototype")
public class CommentAction extends ActionSupport{
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private TopicDao topicDao;
	
	private List<Comment> comments;
	private int referenceId;
	private Integer pageNum;
	private int total;
	private Topic topic;
	private int rid;
	
	private String content;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}
	
	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String fectAll() {
		this.pageNum = this.pageNum==null ? 1:this.pageNum;
		int rows = commentDao.fectAllRows(referenceId);
		int pageSize = 5;
		this.comments = commentDao.fectAll(referenceId, pageNum, pageSize);
		this.total = (rows % pageSize == 0) ? (rows / pageSize) : (rows / pageSize+1);
		if(rows % pageSize == 0) {
			this.total = this.total + 1;
			System.out.println("abc");
		}
		this.topic = topicDao.findById(referenceId);
		return "success";
	}
	
	public String published() throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		HttpServletRequest req = ServletActionContext.getRequest();
		User u = (User)req.getSession().getAttribute("loginUser");
		Comment com = new Comment();
		com.setContent(this.content);
		com.setCommentTime(new Date(System.currentTimeMillis()));
		com.setIp(address.getHostAddress());
		com.setCommentType(2);
		Topic topic = new Topic();
		topic.setId(this.rid);
		com.setTopic(topic);
		User user = new User();
		user.setId(u.getId());
		user.setStatus(u.getStatus());
		com.setUser(user);
		int num = commentDao.addComment(com);
		return "success";
	}
	
	
	
}
