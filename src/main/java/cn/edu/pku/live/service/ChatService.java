package cn.edu.pku.live.service;

import java.util.List;

import cn.edu.pku.live.entity.Chat;

public interface ChatService {

	public void addChat(Chat chat);
	
	public List<Chat> list();
	
}
