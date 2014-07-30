package cn.edu.pku.live.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.pku.live.entity.Chat;
import cn.edu.pku.live.entity.User;
import cn.edu.pku.live.entity.UserStatus;
import cn.edu.pku.live.service.ChatService;
import cn.edu.pku.live.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-common.xml", "classpath:applicationContext-db.xml"})
public class ChatTest {
	
	@Autowired
	private ChatService chatService;
	@Autowired
	private UserService userService;
	
	@Test
	public void addChat(){
		Chat chat = new Chat();
		chat.setContent("Hello");
		chat.setReceiver("Andy");
		chat.setSender("Allen");
		chat.setTime(new Date().toString());
		chatService.addChat(chat);
	}
	
	@Test
	public void addUser(){
		User user = new User();
		user.setGender("男");
		user.setPortrait("");
		user.setStatus(UserStatus.AWAY);
		user.setSupportTeam("spain");
		user.setUsername("Andy");
		userService.addUser(user);
	}
	
}
