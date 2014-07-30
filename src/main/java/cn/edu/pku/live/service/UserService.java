package cn.edu.pku.live.service;

import java.util.List;

import cn.edu.pku.live.entity.User;

public interface UserService {

	public void addUser(User user);
	
	public List<User> listUser();
	
	public boolean loginCheck(String username);
}
