package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.service.LocationService;
@Controller
public class SpringFormController {
	@Autowired
	private LocationService locationService;
	@RequestMapping(value = "/springForm", method = RequestMethod.GET)
	public  ModelAndView  springFormDetails() {
		System.out.println("springFormDetails");
		List<String> basicList=locationService.getBasicLocationDetailsList();
		System.out.println("setting into model"+basicList);
//		List<String> list = getList();

		//return back to index.jsp
		ModelAndView model = new ModelAndView("springForm");
		model.addObject("lists", basicList);

		return model;
	}
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
	
	@RequestMapping(value = "/getListContent", method = RequestMethod.GET)
	public @ResponseBody String getListForCombo() {
		System.out.println("getListForCombo");
		Gson gson= new Gson();
		return gson.toJson(getList()).toString();
	}

	
	@RequestMapping(value = "/dynamicContent", method = RequestMethod.GET)
	public String dynamicContent() {
		System.out.println("dynamicContent");
		return "dynamicContent";
	}
	@RequestMapping(value = "/primaryHtmlContent", method = RequestMethod.GET)
	public String primaryHtmlContent() {
		System.out.println("primaryHtmlContent");
		
		/*String data="<h2>you are getting this data from backend service</h2><a href=\"/Test/springForm\">click to go</a>";
		
		HashMap<String,String> dataMap=new HashMap<String, String>();
		dataMap.put("data", data);
		Gson gson = new Gson();
		String json=gson.toJson(dataMap);*/
		return "primary";
	}
}
