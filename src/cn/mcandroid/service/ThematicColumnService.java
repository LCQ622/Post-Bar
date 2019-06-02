package cn.mcandroid.service;

import java.util.List;

import cn.mcandroid.pojo.ThematicColumn;

public interface ThematicColumnService {
	/**
	 * 该方法用于获取所有栏目（吧）
	 * @return
	 */
	public List<ThematicColumn> getAll();
	
	/**
	 * 该方法用于获取单个栏目 （吧）的信息
	 * @return
	 */
	public ThematicColumn getThematicColumnsByColumn_id( Integer column_id);

}
