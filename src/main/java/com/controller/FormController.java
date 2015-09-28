package com.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.service.LocationService;

@Controller
public class FormController {
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/detailsPage", method = RequestMethod.GET)
	public String printWelcome() {
		System.out.println("serving details page");
		return "form";
	}
	@RequestMapping(value="/getBasic",method=RequestMethod.GET)
	public @ResponseBody String getBasicDetails() {
		System.out.println("inside getBasicDetails");
		String json=null;
		HashMap<String,  HashMap<String, String>> basicDetails = null;
		Gson gson = new Gson();
		try {
			basicDetails = locationService.getBasicLocationDetails();
			json = gson.toJson(basicDetails);
			System.out.println("json"+json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value="/getPrimary",method=RequestMethod.GET)
	public @ResponseBody String getPrimaryDetails(@RequestParam("basicId") String basicId) {
		System.out.println("inside getPrimaryDetails"+basicId);
		String json=null;
		HashMap<Integer, String> primaryDetails = null;
		Gson gson = new Gson();
		try {
			primaryDetails = locationService.getPrimaryDetails(basicId);
			json = gson.toJson(primaryDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public @ResponseBody String getRegisterUser(@RequestParam("country") String country,@RequestParam("state") String state) {
		System.out.println("inside country"+country);
		try {
			locationService.registerUser(country,state);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}




}
