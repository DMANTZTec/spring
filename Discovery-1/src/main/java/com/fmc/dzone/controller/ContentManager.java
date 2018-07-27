package com.fmc.dzone.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fmc.dzone.model.AppData;
import com.fmc.dzone.service.AppDataService;





@Controller
public class ContentManager {
	@Autowired
	AppDataService appDataService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	@RequestMapping("/getApps")
	
	public ModelAndView getEmployees() {
		List<AppData> apps = appDataService.getAllApps();
		ModelAndView model = new ModelAndView("getApps");
		model.addObject("apps", apps);
		return model;
	}
	
	
	@GetMapping(value="/apps/appName/{appName}")
	public AppData getAppDataByName(@PathVariable("appName")String appName) {
		
		
		return appDataService.getAppDataByName(appName);
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Your username and password are invalid.");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}

}
