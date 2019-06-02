package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mcandroid.dao.RepliesMapper;
import cn.mcandroid.pojo.Replies;
import cn.mcandroid.pojo.RepliesExample;
import cn.mcandroid.service.RepliesService;

@Service
public class RepliesServiceimpl implements RepliesService {
	@Autowired
	private RepliesMapper repliesMapper;
	
	@Override
	public List<Replies> getAllRepliesByContentId(Integer contentId) {
		RepliesExample example=new RepliesExample();
		example.or().andContentIdEqualTo(contentId);
		example.setOrderByClause("replies_date desc");
		return repliesMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public boolean addReplies(Replies replies) {
		if(repliesMapper.insert(replies)>0) {
			return true;
		}
		return false;
	}

}
