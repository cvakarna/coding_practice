package com.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class HomeController {
	// DB Connection
	@Autowired
	JdbcTemplate sql;

	@Autowired
	TableUtil util;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public  String getTableList() {
		
		return null;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public  String createTable(@RequestParam(value = "tableName")  String tableName) {
	
		return null;

	}
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public  String readTable(@RequestParam(value = "tableName")  String tableName) {
		SqlRowSet rowSet = sql.queryForRowSet(
				"SELECT * FROM `INFORMATION_SCHEMA`.`COLUMNS` WHERE TABLE_NAME LIKE '" + tableName + "'");
		Gson gson = new Gson();
		return gson.toJson(this.util.getEntitiesFromResultSet(rowSet));

	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public  String updateTable(@RequestParam(value = "tableName")  String tableName) {
		
		return null;

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public  String deleteTable(@RequestParam(value = "tableName")  String tableName) {
		return null;
	}
	
	
}
