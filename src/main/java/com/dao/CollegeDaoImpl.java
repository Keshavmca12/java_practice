package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dto.College;

@Service
public class CollegeDaoImpl implements CollegeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	@Transactional
	public void addCollege(College college) {
		System.out.println(":::::::::::CollegeDaoImpl:::::::::::::::::"+ this.sessionFactory);
		this.sessionFactory.getCurrentSession().save(college);
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<College> getAllColleges() {
		return this.sessionFactory.getCurrentSession().createQuery("from College").list();
	}
	@Override
	@Transactional
	public void deleteCollege(Integer collegeId) {
		College college = (College) sessionFactory.getCurrentSession().load(
				College.class, collegeId);
		if (null != college) {
			this.sessionFactory.getCurrentSession().delete(college);
		}
	}

}
