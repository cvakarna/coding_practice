package com.bizruntime.resourcebundle;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DAOImpl {
	protected static final Logger LOGGER = Logger.getLogger("DAOImpl");

    private static final String DATASOURCE_FILE = "configdatasorce.properties";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static String GETBATCHLABEL = "select batchlabel from labelsproducelabel where LabelBatch=?";

    public static Connection getConnection() {

        LOGGER.debug("inside Connection() of NicelabelDAOimpl ");
        Properties prop = new Properties();

        // getting property file from classpath
        InputStream input = DAOImpl.class.getClassLoader()
                .getResourceAsStream(DAOImpl.DATASOURCE_FILE);
        try {
            prop.load(input);
        } catch (IOException e) {
            LOGGER.error("property file not found in NicelabelDAOimpl class"
                    + e.getMessage());
        }
        // cheking the data coming from property file
        LOGGER.info("driver class : "
                + prop.getProperty(DAOImpl.DRIVER) + ", url : "
                + prop.getProperty(DAOImpl.URL) + ", user : "
                + prop.getProperty(DAOImpl.USERNAME) + ", password : "
                + prop.getProperty(DAOImpl.PASSWORD));

        Connection connection = null;
        try {
            if (connection == null) {
                Class.forName(prop.getProperty(DAOImpl.DRIVER));
                connection = (Connection) DriverManager.getConnection(
                        prop.getProperty(DAOImpl.URL),
                        prop.getProperty(DAOImpl.USERNAME),
                        prop.getProperty(DAOImpl.PASSWORD));
            }

        } catch (ClassNotFoundException e) {

            LOGGER.error("Driver class not found" + e.getMessage());
        } catch (SQLException ce) {
            LOGGER.error("connection exception in getConnection()"
                    + ce.getMessage());
        }
        LOGGER.debug("end of Connection() of NicelabelDAOimpl ");
        return connection;
    }

}
