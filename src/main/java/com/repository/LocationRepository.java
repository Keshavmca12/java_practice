package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dto.University;
import com.modal.Sex;
import com.modal.User;

@Repository
public class LocationRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public Connection getConnection() throws Exception{
		Connection c = null;
		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://localhost:5433/eOffice_ID2",
						"postgres", "postgres");
		System.out.println("Opened database successfully");
		/*HashMap<Integer, String> basicDetails=new HashMap<Integer, String>();
		 connection=locationRepository.getConnection();
	    	   String sql = "select id,subject from ref_head_primary where head_basic_id=?;";
	    	   ps =  connection.prepareStatement(sql);
	    	   ps.setInt(1,Integer.parseInt(basicId));
	           System.out.println("query ::" +sql);
	           ResultSet rs=ps.executeQuery(sql);
	           System.out.println("primary details");
	           while (rs.next()) {

					int id = rs.getInt("id");
					String subject = rs.getString("subject");
					primaryDetails.put(id, subject);
					System.out.println("id : " + id);
					System.out.println("subject : " + subject);

				}
	           ps.close();
	           connection.close();
		System.out.println("basicDetails  ::"+basicDetails);
		System.out.println("data fetched successfully");*/
		return c;
	}

	@Transactional
	public List<User> getUserList(){
		//List<User> userList=(List<User>)sessionFactory.getCurrentSession().createSQLQuery("select * from USERS").list();
		List<User> userList=(List<User>)sessionFactory.getCurrentSession().createQuery("from User").list();
		User usr=userList.get(0);
		return	userList;
	}
	@Transactional
	public List<User> getRoleList(){
		return	sessionFactory.getCurrentSession().createQuery("from Roles").list();
	}

	@Transactional
	public List<University> getAllUniversities() {
		return this.sessionFactory.getCurrentSession().createQuery("from University").list();
	}
	
	@Transactional
	public List<Sex> getList() {
		return this.sessionFactory.getCurrentSession().createQuery("from Sex").list();
	}



}
