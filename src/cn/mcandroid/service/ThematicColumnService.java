package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.ThematicColumn;

public interface ThematicColumnService {
	/**
	 * �÷������ڻ�ȡ������Ŀ���ɣ�
	 * @return
	 */
	public List<ThematicColumn> getAll();
	
	/**
	 * �÷������ڻ�ȡ������Ŀ ���ɣ�����Ϣ
	 * @return
	 */
	public ThematicColumn getThematicColumnsByColumn_id( Integer column_id);

}
