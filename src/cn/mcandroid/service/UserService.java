package cn.mcandroid.service;


import java.util.List;

import cn.mcandroid.pojo.MyPage;
import cn.mcandroid.pojo.User;

public interface UserService {
	
	/**
	 * �÷�������У���û����Ƿ����
	 * @param user ���û�������
	 * @return ���ڼ�����true  �������򷵻�false
	 */
	public boolean verifyUserName(User user);
	/**
	 * �÷�����������û�
	 * @param user ����������
	 * @return  ��ӳɹ�������true  ʧ���򷵻�false
	 */
	public boolean addUser(User user);
	
	/**
	 * ͨ��id��user
	 * @param id �û�id
	 * @return  user����
	 */
	public User getUserById(Integer id);
	/**
	 * ͨ��user ��user
	 * @param user
	 * @return
	 */
	public  User getUserByUser(User user);
	
	/**
	 * �÷������ڵ�¼���жϴ�����û��Ƿ��Ѿ�ע��
	 * @param user
	 * @return
	 */
	public boolean login(User user);
	
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<User> getAllUsers();
	
	public MyPage<User>getAllUser(MyPage<User> myPage);
	
}
