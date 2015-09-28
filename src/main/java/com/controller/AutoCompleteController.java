package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.Tag;
import com.google.gson.Gson;


@Controller
public class AutoCompleteController {
	List<Tag> data = new ArrayList<Tag>();
	public AutoCompleteController() {
		data.add(new Tag(1, "ruby"));
		data.add(new Tag(2, "rails"));
		data.add(new Tag(3, "c / c++"));
		data.add(new Tag(4, ".net"));
		data.add(new Tag(5, "python"));
		data.add(new Tag(6, "java"));
		data.add(new Tag(7, "javascript"));
		data.add(new Tag(8, "jscript"));
	}
	@RequestMapping(value = "/autoComplete", method = RequestMethod.GET)
	public String autoComplete() {
		System.out.println("serving autoComplete page");
		return "autoComplete";
	}

	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public   @ResponseBody String  getContainingTags(@RequestParam("text") String text) {
		System.out.println("getContainingTags   text  :"+text);
		Gson gson= new Gson();
		List<Tag> list=simulateSearchResult(text);
		String json=gson.toJson(list);
		System.out.println("json : "+json);
		return json;
	}
	
	@RequestMapping(value = "/getAllTags", method = RequestMethod.GET)
	public   @ResponseBody String  getAllTags() {
		System.out.println("getAllTags");
		Gson gson= new Gson();
		String json=gson.toJson(data);
		System.out.println("json : "+json);
		return json;
	}

	private List<Tag> simulateSearchResult(String tagName) {
		List<Tag> result = new ArrayList<Tag>();
		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}
		return result;
	}
	
	/*@RequestMapping(value = "/displayData", method = RequestMethod.GET)
	public String dispaydata(@ModelAttribute User usr) {
		System.out.println("dispaydata");
		return "autoComplete";
	}*/


}
