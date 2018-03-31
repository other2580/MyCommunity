package myCommunity.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CommunityTopic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_community_topic", allocationSize = 1)
	private int id;
	private String title;
	private String content;
	private Date createTime;
	private String ip;
	private int commentTimes;
	private Date updateTime;
	private int clicks;
	private int isBest;
	private int status;
	
	@ManyToOne     
	@JoinColumn(name="forumId")
	private Forum forum;
	
	@ManyToOne     
	@JoinColumn(name="authorId")
	private User user;
	
	public Topic() {}
	
	public Topic(int id, String title, String content, Date createTime, int authorId, String iP,
			int commentTimes, Date updateTime, int clicks, int isBest, int status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
		this.ip = iP;
		this.commentTimes = commentTimes;
		this.updateTime = updateTime;
		this.clicks = clicks;
		this.isBest = isBest;
		this.status = status;
	}
	
	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public int getIsBest() {
		return isBest;
	}
	public void setIsBest(int isBest) {
		this.isBest = isBest;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
