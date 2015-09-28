package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	public HashMap<String, HashMap<String, String>> getBasicLocationDetails(){
		HashMap<String, HashMap<String, String>> basicDetails=new HashMap<String, HashMap<String, String>>();
		Connection c = null;
		Statement stmt = null;
		try {
			c =locationRepository.getConnection();

			stmt = c.createStatement();
			String sql = "select id,subject from ref_head_basic;";
			System.out.println("query ::" +sql);
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("basic details");
			while (rs.next()) {
				HashMap<String, String> temp= new HashMap<String, String>();
				int id = rs.getInt("id");
				String subject = rs.getString("subject");
				temp.put("id",id+"");
				temp.put("subject",subject);
				basicDetails.put(subject,temp);
				//System.out.println("id : " + id);
				//	System.out.println("subject : " + subject);

			}
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("basicDetails  ::"+basicDetails);
		System.out.println("basicDetails data fetched successfully");
		return basicDetails;
	}

	public void registerUser(String country,String state) throws Exception{
		Connection connection = null;
		Statement stmt = null; 		
		connection=locationRepository.getConnection();
		stmt = connection.createStatement();
		String sql = "insert into users (state,country)  values(state,country);";
		stmt.executeQuery(sql);
		System.out.println("query ::" +sql);

	}

	public List<String> getBasicLocationDetailsList(){
		List<String> basicDetails=new ArrayList<String>();
		Connection c = null;
		Statement stmt = null;
		try {
			c =locationRepository.getConnection();

			stmt = c.createStatement();
			String sql = "select id,subject from ref_head_basic;";
			System.out.println("query ::" +sql);
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("basic details");
			while (rs.next()) {
				String subject = rs.getString("subject");
				basicDetails.add(subject);
				//System.out.println("id : " + id);
				//	System.out.println("subject : " + subject);

			}
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("basicDetails  list::"+basicDetails);
		System.out.println("basicDetails list fetched successfully");
		return basicDetails;
	}
	public HashMap<Integer,String> getPrimaryDetails(String basicId){
		HashMap<Integer, String> primaryDetails=new HashMap<Integer, String>();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection=locationRepository.getConnection();
			String sql = "select id,subject from ref_head_primary where head_basic_id=?;";
			ps =  connection.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(basicId));
			System.out.println("query ::" +sql);
			ResultSet rs=ps.executeQuery();
			System.out.println("primary details");
			while (rs.next()) {

				int id = rs.getInt("id");
				String subject = rs.getString("subject");
				primaryDetails.put(id, subject);
				//	System.out.println("id : " + id);
				//System.out.println("subject : " + subject);

			}
			ps.close();
			connection.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("primaryDetails  ::"+primaryDetails);
		System.out.println("primaryDetails data fetched successfully");
		return primaryDetails;
	}
}
