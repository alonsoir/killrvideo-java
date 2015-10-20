package com.aironman.cassandra.dao;

import java.util.ArrayList;
import java.util.List;

import com.aironman.cassandra.cluster.CassandraData;
import com.aironman.cassandra.pojo.CommentsUser;
import com.aironman.cassandra.pojo.Videos;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class CommentsDao extends CassandraData{

	/***
	 * q6. Find comments posted by a user with a known id (show most recently posted comments first)
	 */
	public static List<CommentsUser> findCommentsByUserId(String userid){
		//
		// Build a query. This is an example of executing a simple statement.
		//

		String queryText = "SELECT * FROM comments_by_user WHERE userid = ? ORDER BY commentid DESC";
		PreparedStatement preparedStatement = getSession().prepare(queryText);
		BoundStatement boundStatement = preparedStatement.bind(userid);

		//
		// Obtain the results in a ResultSet object
		//

		ResultSet results = getSession().execute(boundStatement);

		//
		// Allocate an empty list of strings to return the artists
		//

		List<CommentsUser> commentsUser = new ArrayList<CommentsUser>();

		//
		// Iterate over the results. For each row, retrieve the "artist" column
		// as a String.
		// and add it to the list of strings.
		//

		for (Row row : results) {
			CommentsUser pojo = new CommentsUser();
			pojo.setUserid(row.getString("userid"));
				
			commentsUser.add(pojo); // Lets use column 0 since there is only one
									// column
		}

		//
		// Return the list of strings.
		//

		return commentsUser;
	}
}
