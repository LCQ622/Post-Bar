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
	 * 该方法将/register转发到 注册页面register.jsp
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
	 * 该方法用于将register.jsp提交过来的的数据进行注册
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

		// result 1. 存在 2. 注册成功 3.注册失败
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
				map.put("msg", "注册失败");
				map.put("result", "3");
			}

		}
		String json = gson.toJson(map);
		return json;
	}

	/**
	 * 该方法用于转发页面到index.jsp
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
	 * 该方用于将页面转发到ThematicColumn.jsp
	 * 
	 * @return
	 */

	@RequestMapping(value = "/ThematicColumn", method = RequestMethod.GET)
	public ModelAndView t4(String column_id) {
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list = new ArrayList<>();
		// 获取栏目（吧）信息
		ThematicColumn thematicColumn = tcs.getThematicColumnsByColumn_id(Integer.parseInt(column_id));
		// 获取栏目（帖子）对应的内容（帖子内容）
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
	 * 该方法用于转发页面到index.jsp
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
	 * 该方法用于转发页面到login.jsp
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
		//获取session 对象
		HttpSession session=req.getSession();
		User user=new User();
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		//获取前台发送过来的数据，并将其设置进user对象中
		user.setUserName(req.getParameter("username"));
		user.setUserPwd(req.getParameter("pwd"));
		//通过userService.login（user）方法判断数据库中是否有该用户
		//1 登录成功 2 用户名不存在 3 用户名密码不正确
		if(userService.login(user)) {
			map.put("login", "1");
			//登录成功后就设置session 
			session.setAttribute("username", user.getUserName());
			session.setAttribute("pwd", user.getUserPwd());
			session.setAttribute("alias", userService.getUserByUser(user).getUserAlias());
			
		}else if(!userService.verifyUserName(user)) {/*  登录失败后，检测库中是否有该用户名*/
			map.put("login", "2");
		}else {/*  否则就返回 3*/
			map.put("login","3");
		}
		return gson.toJson(map);
	}
	
	/**
	 * 该方法用于登出账号
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
	 * 该方法用于转发页面到add_content.jsp
	 * @return
	 */
	@RequestMapping(value="add_content")
	public ModelAndView t9(HttpServletRequest req) {
		HttpSession session=req.getSession();
		//获取栏目（吧）的id
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
	 * 该方法用于提交 帖子内容
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
		
		//add 1 添加成功，add 2 添加成功
		if(contentService.addContent(content)) {
			map.put("add", "1");
		}else {
			map.put("add", "2");
		}
		return gson.toJson(map);
	}
	
	

}
