package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.University;
@Service
public class UniversityDaoImpl implements UniversityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	*/
	@Override
	@Transactional
	public void addUniversity(University university) {
		System.out.println(":::::::::::UniversityDaoImpl:::::::::::::::::"+ this.sessionFactory);
		this.sessionFactory.getCurrentSession().save(university);
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<University> getAllUniversities() {
		return this.sessionFactory.getCurrentSession().createQuery("from University").list();
	}
	@Override
	@Transactional
	public void deleteUniversity(Integer universityId) {
		University university = (University) sessionFactory.getCurrentSession().load(
				University.class, universityId);
		if (null != university) {
			this.sessionFactory.getCurrentSession().delete(university);
		}
	}
}
