package com.controller;

import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dao.CollegeDao;
import com.dao.CollegeDaoImpl;
import com.dao.UniversityDao;
import com.dao.UniversityDaoImpl;
import com.dto.College;
import com.dto.University;
import com.google.gson.Gson;

@Controller
public class HibernateController {
	@Autowired
	@Qualifier("universityDaoImpl")
	private UniversityDao universityDao;
	@Autowired
	CollegeDao collegeDao;

	@RequestMapping(value = "/universityForm", method = RequestMethod.GET)
	public String smartTable() {
		System.out.println("serving universityForm page");
		return "universityForm";
	}
	@RequestMapping(value = "/collegeForm", method = RequestMethod.GET)
	public String treeView() {
		System.out.println("serving collegeForm page");
		return "collegeForm";
	}

	/*@RequestMapping(value = "/submitUniDetails", method = RequestMethod.POST)
	public   @ResponseBody String  submitUniversityDetails(@RequestParam("data") String data) {
		System.out.println("submitUniDetails   data :"+data);
		Gson gson= new Gson();
		University university=gson.fromJson(data, University.class);
		System.out.println("university name"+university.getName());
		universityDao.addUniversity(university);
		return "success";
	}*/
	
	@RequestMapping(value = "/submitUniDetails", method = RequestMethod.POST)
	public   @ResponseBody String  submitUniversityDetails(@RequestBody University university) {
		System.out.println("submitUniDetails   data :"+university);
		/*Gson gson= new Gson();
		University university=gson.fromJson(data, University.class);*/
		System.out.println("university name"+university.getName());
		universityDao.addUniversity(university);
		return "success";
	}
	
	@RequestMapping(value = "/submitCollegeDetails", method = RequestMethod.POST)
	public   @ResponseBody String  submitCollegeDetails(@RequestParam("data") String data) {
		System.out.println("submitCollegeDetails   data :"+data);
		Gson gson= new Gson();
		College college=gson.fromJson(data, College.class);
		System.out.println("college name"+college.getName());
		collegeDao.addCollege(college);
		return "success";
	}
	
	
	@RequestMapping(value = "/universityList", method = RequestMethod.GET)
	public  @ResponseBody  String listUniversitys()
	{
		List<University> list=universityDao.getAllUniversities();
		
		ObjectMapper obj=new ObjectMapper();
		String json = null;
		try {
			json = obj.writeValueAsString(list);
			System.out.println("json   : "+json);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			System.out.println("exp"+e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			System.out.println("exp"+e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("exp"+e);
			e.printStackTrace();
		}
		
	/*	GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
	//	Gson gson=new Gson();
		String json=gson.toJson(list);*/
		return json;
	}
	@RequestMapping("/delete")
	public String deleteEmplyee(@RequestParam("universityId") String universityId)
	{
		universityDao.deleteUniversity(Integer.parseInt(universityId));
		return "success";
	}

	public void setUniversityDaoImpl(UniversityDaoImpl universityDaoImpl) {
		this.universityDao = universityDaoImpl;
	}
	
	public void setCollegeDaoImpl(CollegeDaoImpl collegeDaoImpl) {
		this.collegeDao = collegeDaoImpl;
	}
	

}
