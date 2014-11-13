package com.mlkj.wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlkj.wechat.Iservice.IMainPageService;
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
	private IMainPageService mainPageService;
	
	/**显示人员列表和部门列表
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public String showDepartmentAndUser(ModelMap modelMap) throws Exception{
		List<User> users = mainPageService.getUserList();
		modelMap.addAttribute("users", users);
		return "show";
		
	}
	
	@RequestMapping("/message")
	public String showMessage(ModelMap modelMap) throws Exception{
		modelMap.addAttribute("messages", mainPageService.getTextMessages());
		return "message";
		
	}
	
}
