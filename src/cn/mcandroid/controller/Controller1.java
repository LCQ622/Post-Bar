package cn.mcandroid.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cn.mcandroid.pojo.ThematicColumn;
import cn.mcandroid.pojo.ThematicContent;
import cn.mcandroid.pojo.User;
import cn.mcandroid.service.ThematicColumnService;
import cn.mcandroid.service.ThematicContentService;
import cn.mcandroid.service.UserService;

@Controller
public class Controller1 {

	@Autowired
	private UserService userService;
	@Autowired
	private ThematicColumnService tcs;
	@Autowired
	private ThematicContentService contentService;

	/**
	 * �÷�����/registerת���� ע��ҳ��register.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView t1() {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("register");
		return mView;
	}

	/**
	 * �÷������ڽ�register.jsp�ύ�����ĵ����ݽ���ע��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register_submit", method = RequestMethod.POST)
	@ResponseBody
	public String t2(HttpServletRequest request) {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String alias = request.getParameter("alias");
		String email = request.getParameter("email");
		User user = new User();
		user.setUserName(username);
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();

		// result 1. ���� 2. ע��ɹ� 3.ע��ʧ��
		if (userService.verifyUserName(user)) {
			map.put("result", "1");
		} else {
			user.setUserPwd(pwd);
			user.setUserAlias(alias);
			user.setUserType(1);
			user.setEmail(email);
			user.setCreatedate(new Date());
			if (userService.addUser(user)) {
				map.put("result", "2");
			} else {
				map.put("msg", "ע��ʧ��");
				map.put("result", "3");
			}

		}
		String json = gson.toJson(map);
		return json;
	}

	/**
	 * �÷�������ת��ҳ�浽index.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView t3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", tcs.getAll());
		mv.setViewName("index");
		return mv;

	}

	/**
	 * �÷����ڽ�ҳ��ת����ThematicColumn.jsp
	 * 
	 * @return
	 */

	@RequestMapping(value = "/ThematicColumn", method = RequestMethod.GET)
	public ModelAndView t4(String column_id) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list = new ArrayList<>();
		// ��ȡ��Ŀ���ɣ���Ϣ
		ThematicColumn thematicColumn = tcs.getThematicColumnsByColumn_id(Integer.parseInt(column_id));
		// ��ȡ��Ŀ�����ӣ���Ӧ�����ݣ��������ݣ�
		List<ThematicContent> contents = contentService.getAllByColumn_id(Integer.parseInt(column_id));
		for (int i = 0; i < contents.size(); i++) {
			String msg = contents.get(i).getThematicContent();
			StringBuffer str=new StringBuffer();
			if(msg!=null&&msg.length()>10) {
				str.append(msg.substring(0, 10));
				str.append("...");
				msg=str.toString();
			}
			
			Map<String, Object> map = new HashMap<>();
			map.put("contentId", contents.get(i).getContentId());
			map.put("Title", contents.get(i).getContentTitle());
			map.put("Alias", userService.getUserById(contents.get(i).getUserId()).getUserAlias());
			map.put("msg", msg);
			map.put("date", contents.get(i).getContentCreatedate());
			list.add(map);
		}

		mv.addObject("list", list);
		mv.addObject("obj", thematicColumn);
		mv.setViewName("ThematicColumn");
		return mv;
	}
	
	
	/**
	 * �÷�������ת��ҳ�浽index.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView t5() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", tcs.getAll());
		mv.setViewName("index");
		return mv;

	}
	
	
	/**
	 * �÷�������ת��ҳ�浽login.jsp
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public  ModelAndView t6() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value="/login_submit",method=RequestMethod.POST)
	@ResponseBody
	public String t7(HttpServletRequest req) {
		//��ȡsession ����
		HttpSession session=req.getSession();
		User user=new User();
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		//��ȡǰ̨���͹��������ݣ����������ý�user������
		user.setUserName(req.getParameter("username"));
		user.setUserPwd(req.getParameter("pwd"));
		//ͨ��userService.login��user�������ж����ݿ����Ƿ��и��û�
		//1 ��¼�ɹ� 2 �û��������� 3 �û������벻��ȷ
		if(userService.login(user)) {
			map.put("login", "1");
			//��¼�ɹ��������session 
			session.setAttribute("username", user.getUserName());
			session.setAttribute("pwd", user.getUserPwd());
			session.setAttribute("alias", userService.getUserByUser(user).getUserAlias());
			
		}else if(!userService.verifyUserName(user)) {/*  ��¼ʧ�ܺ󣬼������Ƿ��и��û���*/
			map.put("login", "2");
		}else {/*  ����ͷ��� 3*/
			map.put("login","3");
		}
		return gson.toJson(map);
	}
	
	/**
	 * �÷������ڵǳ��˺�
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	@ResponseBody
	public String t8(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.invalidate();
		return  "<script> location.replace('index');</script>";
	}
	
	
	/**
	 * �÷�������ת��ҳ�浽add_content.jsp
	 * @return
	 */
	@RequestMapping(value="add_content")
	public ModelAndView t9(HttpServletRequest req) {
		HttpSession session=req.getSession();
		//��ȡ��Ŀ���ɣ���id
		int column_id= Integer.parseInt(req.getParameter("column_id"));
		ModelAndView mv = new ModelAndView();
		User user=null;
		if(session.getAttribute("username")!=null&&session.getAttribute("pwd")!=null) {
			User u1=new User();
			u1.setUserName((String)session.getAttribute("username"));
			user=userService.getUserByUser(u1);
		}
		
		
		ThematicColumn thematicColumn = tcs.getThematicColumnsByColumn_id(column_id);
		mv.addObject("thematicColumn", thematicColumn);
		mv.addObject("user",user);
		mv.setViewName("add_content");
		return mv;
	}
	
	/**
	 * �÷��������ύ ��������
	 * @param content
	 * @param req
	 * @return
	 */
	@RequestMapping(value="add_content_submit",method=RequestMethod.POST)
	@ResponseBody
	public String  t10(ThematicContent content,HttpServletRequest req) {
		content.setContentCreatedate(new Date());
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		
		//add 1 ��ӳɹ���add 2 ��ӳɹ�
		if(contentService.addContent(content)) {
			map.put("add", "1");
		}else {
			map.put("add", "2");
		}
		return gson.toJson(map);
	}
	
	

}
