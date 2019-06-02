package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mcandroid.dao.ThematicColumnMapper;
import cn.mcandroid.pojo.ThematicColumn;
import cn.mcandroid.pojo.ThematicColumnExample;
import cn.mcandroid.service.ThematicColumnService;

@Service
public class ThematicColumnServiceimpl implements ThematicColumnService {
	@Autowired
	private ThematicColumnMapper mapper;

	@Override
	public List<ThematicColumn> getAll() {
		List<ThematicColumn> list = mapper.selectByExample(new ThematicColumnExample());
		return list;
	}

	@Override
	public ThematicColumn getThematicColumnsByColumn_id(Integer column_id) {
		return mapper.selectByPrimaryKey(column_id);
	}

	

	

}
