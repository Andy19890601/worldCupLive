package cn.edu.pku.live.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.edu.pku.live.dao.UserDao;
import cn.edu.pku.live.entity.User;
import cn.edu.pku.live.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user) {
		userDao.save(user);
	}

	public List<User> listUser() {
		return userDao.list();
	}

	public boolean loginCheck(String username) {
		return userDao.loginCheck(username);
	}

}
