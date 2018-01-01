package com.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;
@Component
public class TableUtil {

	
	protected void creatTable() {
		
	}
	
	
	protected List<Map<String, Object>> getTableDefinition(SqlRowSet rowSet) {
        List<Map<String, Object>> objects = this.getEntitiesFromResultSet(rowSet);
        
               return objects;
	}
	 protected List<Map<String, Object>> getEntitiesFromResultSet(SqlRowSet rowSet)  {
	        ArrayList<Map<String, Object>> entities = new ArrayList<>();
	        while (rowSet.next()) {
	            entities.add(getEntityFromResultSet(rowSet));
	        }
	        return entities;
	    }

	    protected Map<String, Object> getEntityFromResultSet(SqlRowSet rowSet) {
	    	SqlRowSetMetaData metaData = rowSet.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        Map<String, Object> resultsMap = new HashMap<>();
	        for (int i = 1; i <= columnCount; ++i) {
	            String columnName = metaData.getColumnName(i).toLowerCase();
	            Object object = rowSet.getObject(i);
	            resultsMap.put(columnName, object);
	        }
	        return resultsMap;
	    }

}
