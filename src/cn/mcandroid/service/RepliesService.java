package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.Replies;

public interface RepliesService {
	
	
	/**
	 * 根据帖子编号获取与之相关的所有回复
	 * @param contentId 帖子编号
	 * @return  List<Replies>
	 */
	public List<Replies> getAllRepliesByContentId(Integer contentId);
	
	/**
	 * 该方法用于添加回复
	 * @param replies
	 * @return
	 */
	public boolean addReplies(Replies replies);

}
