package cn.mcandroid.service;


import java.util.List;

import cn.mcandroid.pojo.MyPage;
import cn.mcandroid.pojo.User;

public interface UserService {
	
	/**
	 * 该方法用于校验用户名是否存在
	 * @param user 将用户对象传入
	 * @return 存在即返回true  不存在则返回false
	 */
	public boolean verifyUserName(User user);
	/**
	 * 该方法用于添加用户
	 * @param user 传入对象对象
	 * @return  添加成功即返回true  失败则返回false
	 */
	public boolean addUser(User user);
	
	/**
	 * 通过id找user
	 * @param id 用户id
	 * @return  user对象
	 */
	public User getUserById(Integer id);
	/**
	 * 通过user 找user
	 * @param user
	 * @return
	 */
	public  User getUserByUser(User user);
	
	/**
	 * 该方法用于登录，判断传入的用户是否已经注册
	 * @param user
	 * @return
	 */
	public boolean login(User user);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> getAllUsers();
	
	public MyPage<User>getAllUser(MyPage<User> myPage);
	
}
