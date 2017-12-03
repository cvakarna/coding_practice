package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DatabaseInteraction
 */
@WebServlet("/DatabaseInteraction")
public class DatabaseInteraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DatabaseInteraction() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		 String DB_URL = "jdbc:mysql://localhost/";

		   
		   Connection conn = null;
		   java.sql.Statement stmt = null;
		   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost/empdb", "root", "root");

		      stmt = conn.createStatement();
		      
		      String sql = "select * from employee where eid=1";
		      ResultSet rs=stmt.executeQuery(sql);
		      
		      String name="";
		      int salary=0;
		      int eid=0;
		      
		      while(rs.next()){
		    	  name=rs.getString("name");
		    	  salary=rs.getInt("salary");
		    	  eid=rs.getInt("eid");
		      }
		      
		      response.getWriter().write("Employee id "+eid+" belongs to "+name+" and his salary is "+ salary);
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
	
	}

}
