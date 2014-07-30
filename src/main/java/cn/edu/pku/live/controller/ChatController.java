package cn.edu.pku.live.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.pku.live.entity.Chat;
import cn.edu.pku.live.entity.User;
import cn.edu.pku.live.service.ChatService;

/**
 * 
 * Controller layer of Chat Service.
 * @author stanley_hwang
 *
 */
@Controller
@RequestMapping(value="/chat")
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value="/")
	public String chatPage(){
		return "chat";
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Object addChat(Chat chat, HttpSession session){
		chat.setSender("andy");
		chatService.addChat(chat);
		List<Chat> chatList = chatService.list();
		return chatList;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Object listChat(){
		List<Chat> chatList = chatService.list();
		return chatList;
	} 
	
}
