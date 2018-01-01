package com.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	// DB Connection
	@Autowired
	JdbcTemplate sql;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getTablesList() {
		SqlRowSet rowSet = sql.queryForRowSet("SELECT * FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE TABLE_NAME LIKE 'access_type'");
		String col1 = "HI";
		while (rowSet.next()) {
			col1 = rowSet.getString("TABLE_NAME");
		}
		return col1;

	}

}
