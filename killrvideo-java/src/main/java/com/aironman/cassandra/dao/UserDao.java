package com.aironman.cassandra.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.aironman.cassandra.cluster.CassandraData;
import com.aironman.cassandra.pojo.UserCredentials;
import com.aironman.cassandra.pojo.Users;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;



public class UserDao extends CassandraData {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());

	/***
	 * q1. Find a user with a specified email.
	 */
	public static List<UserCredentials> findUserByEmail(String email) {
		//
	    // Build a query. This is an example of executing a simple statement.
	    //

	    String queryText = "SELECT * FROM user_credentials WHERE email = ?";
	    PreparedStatement preparedStatement = getSession().prepare(queryText);
	    BoundStatement boundStatement = preparedStatement.bind(email);

	    //
	    // Obtain the results in a ResultSet object
	    //

	    ResultSet results = getSession().execute(boundStatement);

	    //
	    // Allocate an empty list of strings to return the artists
	    //

	    List<UserCredentials> users = new ArrayList<UserCredentials>();

	    //
	    // Iterate over the results.  For each row, retrieve the "artist" column as a String.
	    // and add it to the list of strings.
	    //

	    for (Row row : results) {
	    	UserCredentials pojo = new UserCredentials();
	    	pojo.setEmail(row.getString("artist"));
	    	pojo.setPassword(row.getString("artist"));
	    	pojo.setUserid(row.getString("artist"));
	    	users.add(pojo);     // Lets use column 0 since there is only one column
	    }

	    //
	    // Return the list of strings.
	    //

	    return users;
	}
	
	/***
	 * q3. Find a user with a specified id.
	 */
	public static List<Users> findUserByUserdId(String userid){

		//
	    // Build a query. This is an example of executing a simple statement.
	    //

	    String queryText = "SELECT * FROM users WHERE userid = ?";
	    PreparedStatement preparedStatement = getSession().prepare(queryText);
	    BoundStatement boundStatement = preparedStatement.bind(userid);

	    //
	    // Obtain the results in a ResultSet object
	    //

	    ResultSet results = getSession().execute(boundStatement);

	    //
	    // Allocate an empty list of strings to return the artists
	    //

	    List<Users> users = new ArrayList<Users>();

	    //
	    // Iterate over the results.  For each row, retrieve the "artist" column as a String.
	    // and add it to the list of strings.
	    //

	    for (Row row : results) {
	    	Users pojo = new Users();
	    	pojo.setEmail(row.getString("artist"));
	    	pojo.setCreated_date(row.getString("created_date"));
	    	pojo.setUserid(row.getString("artist"));
	    	pojo.setFirstname(row.getString("firstname"));
	    	pojo.setLastname(row.getString("lastname"));
	    	users.add(pojo);     // Lets use column 0 since there is only one column
	    }

	    //
	    // Return the list of strings.
	    //

	    return users;
	}
}
