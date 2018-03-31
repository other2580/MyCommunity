
package myCommunity.dao;

import java.util.List;

import myCommunity.entity.Topic;

public interface TopicDao {

	List<Topic> findTopicTop6();
	
	List<Topic> findBy1(int fornumId);
	
	List<Topic> findBy0(int fornumId, int pageNum, int pageSize);
	
	int findBy0Rows(int fornumId);
	
	List<Topic> findByTitle(int fornumId, String title, int pageNum, int pageSize);
	
	int findByTitleRows(int fornumId, String title);
	
	Topic findById(int id);
}
