package com.gulshan.irs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gulshan.irs.entity.UserEntity;
import com.gulshan.irs.model.Login;
import com.gulshan.irs.model.SearchFlight;
import com.gulshan.irs.service.FlightService;
import com.gulshan.irs.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService = null;
	@Autowired
	FlightService flightService = null;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginDetails() {
		return new ModelAndView("login", "cpmmand", new Login());
	}

	@RequestMapping(value = "/authenticateLogin", method = RequestMethod.POST)
	public ModelAndView authenticateLogin(@Valid @ModelAttribute("command") Login login, BindingResult result,
			ModelMap model) {

		System.out.println("entered in Logincontroller");
		ModelAndView modelAndView = new ModelAndView("errorLogin");
		try {
			if (result.hasErrors()) {
				modelAndView = new ModelAndView("login");
			} else {
				System.out.println("Calling LoginService");

				UserEntity userEntity = loginService.authenticateLogin(login);
				System.out.println(userEntity.getUserId());
				

				System.out.println("before calling flightservice");
				List<String> flightSource = flightService.getSources();

				model.addAttribute("sourceList", flightSource);
				List<String> flightDestination = flightService.getDestination();
				model.addAttribute("destinationList", flightDestination);
				modelAndView = new ModelAndView("searchFlights", "command", new SearchFlight());
				modelAndView.addObject("userModel", userEntity);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modelAndView;
	}
}
