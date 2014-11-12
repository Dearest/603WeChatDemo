package com.mlkj.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlkj.wechat.Iservice.MainPageIService;
import com.mlkj.wechat.model.User;

/**
 * 首页的控制器
 * @author hanchen
 *
 */
@Controller
@RequestMapping("/main")
public class MainPageController {
	@Resource(name="mainPageService")
	private MainPageIService mainPageService;
	
	@RequestMapping("/show")
	public String showDepartmentAndUser(ModelMap modelMap) throws Exception{
		List<User> users = mainPageService.getUserList();
		modelMap.addAttribute("users", users);
		return "show";
		
	}
	
}
