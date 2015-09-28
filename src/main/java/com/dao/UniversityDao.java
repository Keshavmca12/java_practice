package com.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.University;
@Service
public interface UniversityDao {
	public void addUniversity(University university);
	public List<University> getAllUniversities();
	public void deleteUniversity(Integer universityId);
}
