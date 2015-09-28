package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;
@Repository
public class FlCorrespondenceRecieptRepo {

	public Connection getConnection() throws Exception{
		Connection c = null;
		Class.forName("org.postgresql.Driver");
		c = DriverManager
				.getConnection("jdbc:postgresql://10.248.80.14:5432/eofficeID3",
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
}
