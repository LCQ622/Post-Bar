package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.ThematicContent;

public interface ThematicContentService {

	/**
	 * 该方法用于获取指定吧编号column_id的所有帖子
	 * @return
	 */
	public List<ThematicContent> getAllByColumn_id(Integer column_id);
	
	
	/**
	 * 该方法用于添加帖子
	 * @param content
	 * @return
	 */
	public boolean addContent(ThematicContent content);
	
	
	/**
	 * 该方法通过帖子编号，获取该编号帖子的所有内容
	 * @param contentId
	 * @return
	 */
	public ThematicContent geThematicContentByContentId(Integer contentId);
}
