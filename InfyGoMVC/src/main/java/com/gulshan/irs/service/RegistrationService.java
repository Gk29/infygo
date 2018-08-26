package com.gulshan.irs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gulshan.irs.DAO.UserRegisterationDAO;
import com.gulshan.irs.entity.UserEntity;
import com.gulshan.irs.model.User;
@Service
public class RegistrationService {
	@Autowired
	private UserRegisterationDAO userRegisterationDao;
	
 public void registerUser(User user) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setCity(user.getCity());
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		System.out.println("");
		
		userRegisterationDao.addUser(userEntity);
		
		
	}

public UserEntity findUser(String userId) {
	// TODO Auto-generated method stub
	UserEntity userEntity=new UserEntity();
	System.out.println("in registration and going to DAo class");
	userEntity=userRegisterationDao.getDetails(userId);
	System.out.println("in registration and came from  DAo class with " +userEntity.getName());
	return userEntity;
}

	public List<UserEntity> getUserList() {
	
		List<UserEntity> userList=userRegisterationDao.getUserList();
		
		return userList;
	}
}
