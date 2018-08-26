package com.gulshan.irs.controller;

import java.util.List;
import org.apache.log4j.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gulshan.irs.entity.UserEntity;
import com.gulshan.irs.model.User;
import com.gulshan.irs.service.RegistrationService;

@RestController
public class RegistrationController {

	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET,produces="application/json")
	@ResponseBody
	public  List<UserEntity> getUserList() {

		List<UserEntity> userList = registrationService.getUserList();
		System.out.println("back to controller");
		for (UserEntity userenity : userList) {
			System.out.println(userenity.getName());
		}
		logger.info("returning UserlIst");
		return userList;
	}

	@RequestMapping(value = "/finduser", method = RequestMethod.GET)
	public ModelAndView findUser() {

		ModelAndView modelAndView = new ModelAndView("getDetails");

		return modelAndView;
	}

	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ModelAndView getUser(@RequestParam("userId") String userId) {

		// logs debug message
		if (logger.isDebugEnabled()) {
			logger.debug("getUser is executed!");
		}
		// logs exception
		logger.error("This is Error message", new Exception("Testing"));
		
		
		UserEntity ue = registrationService.findUser(userId.trim());
		System.out.println(ue.getName() + "  " + ue.getEmail());

		ModelAndView modelAndView = new ModelAndView("userDetails");
		modelAndView.addObject("user", ue);
		modelAndView.addObject("message", "you have entered UserId : " + userId);
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public Object register(Model model) {
		ModelAndView modelandview = new ModelAndView("register", "command", new User());
		return modelandview;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView addCustomer(@Valid @ModelAttribute("command") User user, BindingResult result, ModelMap model) {
		ModelAndView modelandview = new ModelAndView("successR");
		if (result.hasErrors()) {
			ModelAndView modelandview1 = new ModelAndView("register");
			modelandview1.addObject("message", "got some error from binding result ");
			return modelandview1;
		} else {
			try {
				registrationService.registerUser(user);
				modelandview.addObject("userModel", user);
				modelandview.addObject("message", "succefully transmitted the user value");

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error found i am in controller catch");
				e.printStackTrace();
			}
		}
		return modelandview;

	}

}
