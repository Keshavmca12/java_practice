package com.dao;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dto.College;

@Service
public interface CollegeDao {
	public void addCollege(College college);
	public List<College> getAllColleges();
	public void deleteCollege(Integer collegeId);

}
