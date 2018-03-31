package myCommunity.dao;

import java.util.List;

import myCommunity.entity.Comment;

public interface CommentDao {

	List<Comment> fectAll(int referenceId, int pageNum, int pageSize);
	
	int fectAllRows(int referenceId);
	
	int addComment(Comment com);
}
