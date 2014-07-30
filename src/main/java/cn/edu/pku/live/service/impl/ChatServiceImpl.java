package cn.edu.pku.live.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.pku.live.dao.ChatDao;
import cn.edu.pku.live.entity.Chat;
import cn.edu.pku.live.service.ChatService;

/**
 * The implement of chat service layer.
 * 
 * @author stanley_hwang
 *
 */
@Service
public class ChatServiceImpl implements ChatService{
	
	@Autowired
	private ChatDao chatDao;
	
	public void addChat(Chat chat){
		chatDao.save(chat);
	}

	public List<Chat> list() {
		return chatDao.list();
	}
	
}
