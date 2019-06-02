package cn.mcandroid.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.mcandroid.pojo.Replies;
import cn.mcandroid.pojo.ThematicColumn;
import cn.mcandroid.pojo.ThematicContent;
import cn.mcandroid.pojo.User;
import cn.mcandroid.service.RepliesService;
import cn.mcandroid.service.ThematicColumnService;
import cn.mcandroid.service.ThematicContentService;
import cn.mcandroid.service.UserService;


@Controller
public class contentController {
	

	@Autowired
	private UserService userService;
	@Autowired
	private ThematicColumnService tcs;
	@Autowired
	private ThematicContentService contentService;
	@Autowired
	private RepliesService repliesService;

	@RequestMapping(value="thematic_content",method=RequestMethod.GET)
	public ModelAndView t1(Integer contentId,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		ThematicContent content =contentService.geThematicContentByContentId(contentId);
		//user1 是发帖人，user2 是回复帖子的人
		User user1 =userService.getUserById(content.getUserId());
		ThematicColumn thematicColumn =tcs.getThematicColumnsByColumn_id(content.getColumnId());
		List<Replies>res=repliesService.getAllRepliesByContentId(contentId);
		List<Map<String, Object>> list=new ArrayList<>();
		
		for (Replies replies2 : res) {
			Map <String ,Object>map=new HashMap<>();
			User u1=userService.getUserById(replies2.getUserId());
			map.put("name", u1.getUserAlias());
			map.put("RepliesDate", replies2.getRepliesDate());
			map.put("RepliesContent", replies2.getRepliesContent());
			list.add(map);
		}
		
		mv.addObject("content",content);
		mv.addObject("user1",user1);
		mv.addObject("list",list);
		mv.addObject("thematicColumn",thematicColumn);
		mv.setViewName("thematic_content");
		return mv;
		
	}
	
	@RequestMapping(value="replies_submit",method=RequestMethod.POST)
	@ResponseBody
	public  String t2(Integer contentId,String username,String repliesContent) {
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		if(!username.equals("")) {
			User u1=new User();
			u1.setUserName(username);
			User u2=userService.getUserByUser(u1);
			Replies replies=new Replies();
			replies.setContentId(contentId);
			replies.setRepliesContent(repliesContent);
			replies.setUserId(u2.getUserId());
			replies.setRepliesDate(new Date());
			if(repliesService.addReplies(replies)) {
				// 1.添加成功 
				map.put("replies", "1");
			}else {
				map.put("replies", "2");
			}
		}
		
		return gson.toJson(map);
	}


}
