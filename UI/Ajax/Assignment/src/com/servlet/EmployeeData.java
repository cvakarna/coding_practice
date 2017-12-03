package com.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.pojo.Employee;

@WebServlet("/toServlet")
public class EmployeeData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String jsonInString = request.getParameter("jsonObj");
		Employee emp;

		ObjectMapper mapper = new ObjectMapper();
		emp = mapper.readValue(jsonInString, Employee.class);
		
		boolean result = insertIntoDatabase(emp);
		
		response.setContentType("application/html");
		Writer out = response.getWriter();
		if (result) {
			out.write("<h3>Record Successfully Inserted.</h3>");
		} else {
			out.write("Record not inserted. Please refill the form correctly");
		}

	}

	private boolean insertIntoDatabase(Employee emp) {

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empdb",
					"root", "root");

			String sql = "insert into employee1 values(?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getAddress().getStreet());
			stmt.setString(5, emp.getAddress().getCity());
			stmt.setString(6, emp.getAddress().getState());
			stmt.setLong(7, emp.getPhone());
			int res = stmt.executeUpdate();

			if (res > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return false;

	}

}
