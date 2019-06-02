package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mcandroid.dao.ThematicContentMapper;
import cn.mcandroid.pojo.ThematicContent;
import cn.mcandroid.pojo.ThematicContentExample;
import cn.mcandroid.service.ThematicContentService;

@Service
public class ThematicContentServiceimpl implements ThematicContentService {
	@Autowired
	private ThematicContentMapper mapper;

	@Override
	public List<ThematicContent> getAllByColumn_id(Integer column_id) {
		ThematicContentExample example = new ThematicContentExample();
		example.or().andColumnIdEqualTo(column_id);
		example.setOrderByClause("content_createdate desc");
		//字段中有text类型的需要使用selectByExampleWithBLOBs 
		List<ThematicContent> list = mapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public boolean addContent(ThematicContent content) {
		if(mapper.insert(content)>0) {
			return true;
		}
		return false;
	}

	@Override
	public ThematicContent geThematicContentByContentId(Integer contentId) {
		return mapper.selectByPrimaryKey(contentId);
		
	}

}
