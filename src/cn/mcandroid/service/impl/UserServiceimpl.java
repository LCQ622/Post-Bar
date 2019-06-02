package cn.mcandroid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.recompile;

import cn.mcandroid.dao.UserMapper;
import cn.mcandroid.pojo.MyPage;
import cn.mcandroid.pojo.User;
import cn.mcandroid.pojo.UserExample;
import cn.mcandroid.service.UserService;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean verifyUserName(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(user.getUserName());
		List<User> list = userMapper.selectByExample(example);

		for (User user2 : list) {
			if (user2.getUserName().equals(user.getUserName())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean addUser(User user) {
		int count=userMapper.insert(user);
		if(count>0) {
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean login(User user) {
		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(user.getUserName());
		List<User>list=userMapper.selectByExample(example);
		for (User user2 : list) {
			if (user.getUserName().equals(user2.getUserName()) &&user.getUserPwd().equals(user2.getUserPwd())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getUserByUser(User user) {
		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(user.getUserName());
		if( userMapper.selectByExample(example).size()>0)
		{
			return userMapper.selectByExample(example).get(0);
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.selectByExample(null);
	}

	@Override
	public MyPage<User> getAllUser(MyPage<User> myPage) {

		Page page = PageHelper.startPage(myPage.getPageNum(), myPage.getPageSize(), true);
		List<User>list=userMapper.selectByExample(null);
		if(list!=null) {
			MyPage<User> p1=new MyPage<User>();
			p1.setList(list);
			p1.setCount(page.getPages());
			p1.setPageNum(myPage.getPageNum()+myPage.getPageSize());
			p1.setPageSize(myPage.getPageSize());
			return p1;
		}
		return null;
	}

}
