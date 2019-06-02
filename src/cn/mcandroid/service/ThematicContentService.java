package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.ThematicContent;

public interface ThematicContentService {

	/**
	 * �÷������ڻ�ȡָ���ɱ��column_id����������
	 * @return
	 */
	public List<ThematicContent> getAllByColumn_id(Integer column_id);
	
	
	/**
	 * �÷��������������
	 * @param content
	 * @return
	 */
	public boolean addContent(ThematicContent content);
	
	
	/**
	 * �÷���ͨ�����ӱ�ţ���ȡ�ñ�����ӵ���������
	 * @param contentId
	 * @return
	 */
	public ThematicContent geThematicContentByContentId(Integer contentId);
}
