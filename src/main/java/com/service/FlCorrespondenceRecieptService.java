
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.FLReciept;
import com.repository.FlCorrespondenceRecieptRepo;
@Service
public class FlCorrespondenceRecieptService {

	@Autowired
	FlCorrespondenceRecieptRepo correspondenceRecieptRepo;

	public List<FLReciept> tableData(){
		List<FLReciept> basicDetails=new ArrayList<FLReciept>();
		Connection c = null;
		Statement stmt = null;
		try {
			c =correspondenceRecieptRepo.getConnection();

			stmt = c.createStatement();
			String sql = "select * from fl_correspondence_receipt as fl limit 100;";
			System.out.println("query ::" +sql);
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				FLReciept flReciept=new FLReciept();
				flReciept.setCorrespondenceNumber(rs.getString("correspondence_number"));
				flReciept.setLetterNumber(rs.getString("letter_number"));
				flReciept.setReferenceNumber(rs.getDate("receipt_creation_date")+"");
				flReciept.setSubject(rs.getString("subject"));
				flReciept.setModeId(rs.getLong("mode_id_fk"));
				flReciept.setVip(rs.getBoolean("is_vip"));
				basicDetails.add(flReciept);
			}
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("basicDetails list size ::"+basicDetails.size());
		return basicDetails;
	}

	public Map<String,Object> tablePaginatedData(int start,int number){
		Map<String,Object> basicDetailsMap=new HashMap<String,Object>();
		List<FLReciept> basicDetails=new ArrayList<FLReciept>();
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c =correspondenceRecieptRepo.getConnection();
			String sql = "select * from fl_correspondence_receipt  ORDER BY correspondence_id ASC OFFSET  "+start+" ROWS FETCH NEXT "+number+" ROWS ONLY ;"; 
			System.out.println("query ::" +sql);
			stmt = c.prepareStatement(sql);
			/*int index=1;
			stmt.setInt(index++, 0);
			stmt.setInt(index++, 10);*/
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				FLReciept flReciept=new FLReciept();
				flReciept.setCorrespondenceNumber(rs.getString("correspondence_number"));
				flReciept.setLetterNumber(rs.getString("letter_number"));
				flReciept.setReferenceNumber(rs.getDate("receipt_creation_date")+"");
				flReciept.setSubject(rs.getString("subject"));
				flReciept.setModeId(rs.getLong("mode_id_fk"));
				flReciept.setVip(rs.getBoolean("is_vip"));
				basicDetails.add(flReciept);
			}
			stmt.close();
			c.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		basicDetailsMap.put("list",basicDetails);
		basicDetailsMap.put("pages",(noOfRecord()/number)+1);
		System.out.println("tablePaginatedData basicDetailsMap ::"+basicDetailsMap);
		return basicDetailsMap;
	}


	private int noOfRecord(){
		int  count=-1;
		Connection c = null;
		Statement stmt = null;
		try {
			c =correspondenceRecieptRepo.getConnection();
			stmt = c.createStatement();
			String sql = "select count(*) from fl_correspondence_receipt;";
			System.out.println("query ::" +sql);
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				count=rs.getInt(1);
			}
			System.out.println("no mof records "+count);
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
		}
		return count;

	};

}
