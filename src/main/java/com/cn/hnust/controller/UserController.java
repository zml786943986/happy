package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
}
