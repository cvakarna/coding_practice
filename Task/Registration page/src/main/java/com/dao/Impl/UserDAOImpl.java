package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDAO;
import com.dbconnection.DBConnection;
import com.models.User;

public class UserDAOImpl implements UserDAO {

	public boolean insert(User user) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnection.getConnection();
			String sql="insert into SampleProject (registerID,firstName,middleName,lastName,dob,uniqueID,panNumber,gender,"+
                              "maritalStatus,communicationAddress,permanentAddress)"
                              		+ " values (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1,user.getRegisterID() );
			pstmt.setString(2, user.getFirstName());
			pstmt.setString(3, user.getMiddleName());
			pstmt.setString(4, user.getLastName());
			pstmt.setString(5, user.getDob());
			pstmt.setString(6, user.getuniqueId());
			pstmt.setString(7, user.getPanNumber());
			pstmt.setString(8, user.getGender());
			pstmt.setString(9, user.getMaritalStatus());
			pstmt.setString(10, user.getCommunicationAddress());
			pstmt.setString(11, user.getPermanentAddress());
			/*pstmt.setString(12, user.getCourse());
			pstmt.setString(13, user.getCollege());
			pstmt.setString(14, user.getYearOfSucess());
			pstmt.setDouble(15, user.getPercentage());
*/
			pstmt.executeUpdate();

		} catch (SQLException sqlexp) {
			//log.error(sqlexp.getMessage());
		} catch (ClassNotFoundException e) {
			//log.error(e.getMessage());
		} finally {
			DBConnection.dbCleanUp(con, pstmt);
		}
		return true;		
	}

	public User getUserById() {
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			con = DBConnection.getConnection();
			String sql="select * from sample project where userID=?";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, "1");
			rs=pstmt.executeQuery();
			user=new User();
			while(rs.next()){
				user.setFirstName(rs.getString("firstName"));
				user.setMiddleName(rs.getString("middleName"));
				user.setLastName(rs.getString("lastName"));
				user.setDob(rs.getString("dob"));
				user.setPanNumber(rs.getString("panNumber"));
				user.setuniqueId(rs.getString("uniqueId"));
				
			}
			
		} catch (SQLException sqlexp) {
			//log.error(sqlexp.getMessage());
		} catch (ClassNotFoundException e) {
			//log.error(e.getMessage());
		} finally {
			DBConnection.dbCleanUp(con, pstmt);
		}	
		return user;
	}

}
