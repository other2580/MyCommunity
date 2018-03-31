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
@Table(name="CommunityComment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_community_comment", allocationSize = 1)
	private int id;
	private String content;
	private Date commentTime;
	private String ip;
	private int commentType;
	private int status;
	@ManyToOne     
	@JoinColumn(name="ReferenceId")
	private Topic topic;
	@ManyToOne     
	@JoinColumn(name="CommenterId")
	private User user;
	
	public Comment() {}
	
	public Comment(int id, String content, Date commentTime, String ip, int commentType, int status) {
		super();
		this.id = id;
		this.content = content;
		this.commentTime = commentTime;
		this.ip = ip;
		this.commentType = commentType;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCommentType() {
		return commentType;
	}
	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
