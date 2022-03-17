package com.crm.autodesk.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection connection=null;
	/**
	 * This method will do the connection to database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection= DriverManager.getConnection(IPathConstants.DATABASE_URL,"root","root");
	}
	/**
	 * This method will close the database connection
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable {
		connection.close();
	}	
	/**
	 * Method will fetch all the data from the database
	 * @param querry
	 * @return
	 * @throws Throwable 
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * Method will update the data in database and it will verify 
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public boolean updateData(String querry) throws Throwable {
		boolean flag=false;
		int result = connection.createStatement().executeUpdate(querry);
		if(result==1) {
			System.out.println("data is Updated in database");
			flag=true;
		}else {
			System.out.println("data is not updated in database");
		}
		return flag;
	}
	/**
	 * This method will verify the given data is present in the database or not
	 * @param querry
	 * @param colunmNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String querry,int colunmNumber,String expectedData) throws Throwable {
		boolean flag=false;
		String actualData = null;
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			String data = result.getString(colunmNumber);
			if(data.equals(expectedData)){
				actualData=data;
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Data is present in the database");
			return actualData;
		}else {
			System.out.println("Data is not present in database");
			return actualData;
		}
	}
}
