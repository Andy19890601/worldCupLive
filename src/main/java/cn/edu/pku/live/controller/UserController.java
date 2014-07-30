package cn.edu.pku.live.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.pku.live.entity.User;
import cn.edu.pku.live.service.UserService;

@Controller
@RequestMapping(value="/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login")
	@ResponseBody
	public Object login(String username, HttpSession session){
		Map<String, Object> reminderMap = new HashMap<String, Object>();
		if(userService.loginCheck(username)){
			reminderMap.put("reminder_msg", "用户名已存在");
			return reminderMap;
		}else{
			User user = new User();
			user.setUsername(username);
			user.setPortrait(generateRandomPortrait());
			userService.addUser(user);
			session.setAttribute("userSession", user);
			return "redirect:/chat/";
		}
	}
	
	public String generateRandomPortrait(){
		String[] portrait = new String[]{"av1_1.jpg","av1.jpg","av2.jpg"};
		int index = (int)(Math.random()*portrait.length);
		return portrait[index];
	}
	
	
}
