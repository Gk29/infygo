package com.gulshan.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gulshan.irs.DAO.UserRegisterationDAO;
import com.gulshan.irs.entity.UserEntity;
import com.gulshan.irs.exception.InvalidCredentialException;
import com.gulshan.irs.model.Login;

@Service
public class LoginService {
	@Autowired
	UserRegisterationDAO userregistrationDao =null;
	
	public UserEntity authenticateLogin(Login userLogin) throws InvalidCredentialException {
		System.out.println("Entered in LoginService");
		
		UserEntity userEntity=userregistrationDao.findOne(userLogin.getUserName());
		System.out.println("existing Login service");
		
	
		if(userEntity==null ) {
			System.out.println("Inside First IF of authenticate login");
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");
		}else if (!(userLogin.getPassword().equals(userEntity.getPassword()))) {
			//userEntity.getPassword().trim() != userLogin.getPassword().trim()
			System.out.println("inside elsif of authenticate login");
			throw new InvalidCredentialException("LoginService.INVALID_CREDENTIALS");
		}
		return userEntity;
		
	}

}
