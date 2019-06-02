package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.Replies;

public interface RepliesService {
	
	
	/**
	 * �������ӱ�Ż�ȡ��֮��ص����лظ�
	 * @param contentId ���ӱ��
	 * @return  List<Replies>
	 */
	public List<Replies> getAllRepliesByContentId(Integer contentId);
	
	/**
	 * �÷���������ӻظ�
	 * @param replies
	 * @return
	 */
	public boolean addReplies(Replies replies);

}
