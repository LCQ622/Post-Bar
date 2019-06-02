package cn.mcandroid.controller;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.mcandroid.pojo.MyPage;
import cn.mcandroid.pojo.User;
import cn.mcandroid.service.UserService;

@Controller
public class Bmanage {
	@Autowired
	private UserService userService;

	@RequestMapping(value="bg",method=RequestMethod.GET)
	public  ModelAndView t1(Integer p) {
		ModelAndView mvAndView=new ModelAndView();
		MyPage<User> p1=new MyPage<>();
		p1.setPageNum(p);
		p1.setPageSize(2);
		mvAndView.addObject("list",userService.getAllUser(p1).getList());
		mvAndView.setViewName("bgmanage");
		return mvAndView;
	}
}
