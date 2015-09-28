package com.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.University;
@Service
public class DaoTestImpl implements UniversityDao {

	@Override
	public void addUniversity(University university) {
		// TODO Auto-generated method stub
		System.out.println("addUniversity");
		
	}

	@Override
	public List<University> getAllUniversities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUniversity(Integer universityId) {
		// TODO Auto-generated method stub
		
	}

}
