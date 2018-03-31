package myCommunity.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CommunityForum")
public class Forum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "seq_community_forum", allocationSize = 1)
	private int id;
	private String name;
	private String description;
	private Integer parentId;
	
	@ManyToOne     
	@JoinColumn(name="ParentId")
	private Forum forums;
	
	@OneToMany(mappedBy="forums")
	private List<Forum> forum;
	
	public Forum(){}
	
	public Forum(int id, String name, String description, int parentId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}
	
	public int getId() {
		return id;             
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Forum getForums() {
		return forums;
	}

	public void setForums(Forum forums) {
		this.forums = forums;
	}

	public List<Forum> getForum() {
		return forum;
	}

	public void setForum(List<Forum> forum) {
		this.forum = forum;
	}
	
}
