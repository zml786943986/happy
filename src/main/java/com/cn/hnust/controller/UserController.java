package com.cn.hnust.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.domain.SysMenu;
import com.cn.hnust.domain.User;
import com.cn.hnust.service.IUserService;

/**
 * 
 * TODO Controller
 * <p style="display:none">modifyRecord</p>
 * <p style="display:none">version:V1.0,author:293320,date:2017-1-10 下午3:14:48,content:TODO </p>
 * @author 293320
 * @date 2017-1-10 下午3:14:48
 * @since
 * @version
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest request,Model model){
//		int userId = Integer.parseInt(request.getParameter("id"));
//		User user = this.userService.getUserById(userId);
//		model.addAttribute("user", user);
		return "showUser";
	}
	
	@RequestMapping("/showUsers")
	@ResponseBody
	public Map showUsers(User u,int page,int rows){
		Map map = new HashMap();
        List<User> user = userService.queryUserList(u,page,rows);
        Integer count = userService.countUser(u);
        map.put("rows",user);
        map.put("total", count);
        return map;
        
	}
	
	@RequestMapping("/toMenu")
	public String toMenu(HttpServletRequest request,Model model){
		return "showMenu";
	}
	
//	@RequestMapping(value = "/showMenus/{menu}", method = RequestMethod.GET)
	@RequestMapping("/showMenus")
	@ResponseBody
	public List showMenus(String menuId){
		SysMenu menu = new SysMenu();
		menu.setMenuId(menuId);
		List menus = userService.getAllMenuList(menu);
        return menus;
	}
	
}
