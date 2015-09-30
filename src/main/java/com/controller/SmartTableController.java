package com.controller;

import java.util.List;
import java.util.Map;

import com.dto.FLReciept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.service.FlCorrespondenceRecieptService;
@Controller
public class SmartTableController {
	@Autowired
	FlCorrespondenceRecieptService flCorrespondenceRecieptService;
	
	@RequestMapping(value = "/smartTable", method = RequestMethod.GET)
	public String smartTable() {
		System.out.println("serving smartTable page");
		return "smartTable";
	}
	@RequestMapping(value = "/treeView", method = RequestMethod.GET)
	public String treeView() {
		System.out.println("serving treeView page");
		return "treeView";
	}
	
	@RequestMapping(value="/getTablePaginatedData",method=RequestMethod.GET)
	public @ResponseBody String getTablePaginatedData(@RequestParam("start")String start,@RequestParam("number")String number,@RequestParam("paramsData")Object dataParams) {
		System.out.println("inside getTablePaginatedData  start  :"+start +"   number  :"+number  +"  dataParams    :"+dataParams);
		String json=null;
		Map<String,Object> basicDetailsMap = null;
		Gson gson = new Gson();
		try {
			basicDetailsMap = flCorrespondenceRecieptService.tablePaginatedData(Integer.parseInt(start),Integer.parseInt(number));
			json = gson.toJson(basicDetailsMap);
			//System.out.println("json"+json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/getFLCorrepondeceData",method=RequestMethod.GET)
	public @ResponseBody String getFLCorrepondeceData() {
		System.out.println("inside getFLCorrepondeceData");
		String json=null;
		List<FLReciept> basicDetails = null;
		Gson gson = new Gson();
		try {
			basicDetails = flCorrespondenceRecieptService.tableData();
			json = gson.toJson(basicDetails);
			//System.out.println("json"+json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
