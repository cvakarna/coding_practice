package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.pojo.Address;
import com.pojo.Employee;

@WebServlet("/getEmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDetails() {
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		String JsonInString = mapper.writeValueAsString(employeeInfo());
		response.setContentType("application/json");
		response.getWriter().write(JsonInString);

	}

	List employeeInfo() {

		Connection conn = null;
		Statement stmt = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/empdb",
					"root", "root");

			String sql = "select * from employee1";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Employee emp;
			Address add;
			int i = 0;
			while (rs.next()) {
				emp = new Employee();
				add = new Address();
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				add.setStreet(rs.getString(4));
				add.setCity(rs.getString(5));
				add.setState(rs.getString(6));

				emp.setAddress(add);
				emp.setPhone(rs.getLong(7));

				list.add(emp);
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

		return list;

	}

}
