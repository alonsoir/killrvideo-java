package com.aironman.cassandra.dao;

import java.util.ArrayList;
import java.util.List;

import com.aironman.cassandra.cluster.CassandraData;
import com.aironman.cassandra.pojo.UserVideos;
import com.aironman.cassandra.pojo.Videos;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

public class VideoDao extends CassandraData {

	/***
	 * q4. Find videos uploaded by a user with a known id(show most recently
	 * uploaded videos first)
	 */
	public static List<UserVideos> findUploadedVideosbyUserId(String userid) {
		//
		// Build a query. This is an example of executing a simple statement.
		//

		String queryText = "SELECT * FROM user_videos WHERE userid = ? ORDER BY added_date DESC videoid ASC";
		PreparedStatement preparedStatement = getSession().prepare(queryText);
		BoundStatement boundStatement = preparedStatement.bind(userid);

		//
		// Obtain the results in a ResultSet object
		//

		ResultSet results = getSession().execute(boundStatement);

		//
		// Allocate an empty list of strings to return the artists
		//

		List<UserVideos> uservideos = new ArrayList<UserVideos>();

		//
		// Iterate over the results. For each row, retrieve the "artist" column
		// as a String.
		// and add it to the list of strings.
		//

		for (Row row : results) {
			UserVideos pojo = new UserVideos();
			pojo.setUserid(row.getString("userid"));
			pojo.setAdded_date(row.getString("added_date"));
			pojo.setName(row.getString("name"));
			pojo.setPreview_image_location(row.getString("preview_image_location"));
			pojo.setVideoid(row.getString("videoid"));
			uservideos.add(pojo); // Lets use column 0 since there is only one
									// column
		}

		//
		// Return the list of strings.
		//

		return uservideos;
	}
	
	/***
	 * q5. Find a video with a specified video id
	 */
	public static List<Videos> findVideoByVideoId(String videoid){

		//
		// Build a query. This is an example of executing a simple statement.
		//

		String queryText = "SELECT * FROM videos WHERE videoid = ? ORDER BY added_date DESC videoid ASC";
		PreparedStatement preparedStatement = getSession().prepare(queryText);
		BoundStatement boundStatement = preparedStatement.bind(videoid);

		//
		// Obtain the results in a ResultSet object
		//

		ResultSet results = getSession().execute(boundStatement);

		//
		// Allocate an empty list of strings to return the artists
		//

		List<Videos> videos = new ArrayList<Videos>();

		//
		// Iterate over the results. For each row, retrieve the "artist" column
		// as a String.
		// and add it to the list of strings.
		//

		for (Row row : results) {
			Videos pojo = new Videos();
			pojo.setUserid(row.getString("userid"));
			pojo.setAdded_date(row.getString("added_date"));
			pojo.setName(row.getString("name"));
			pojo.setPreview_image_location(row.getString("preview_image_location"));
			pojo.setLocation(row.getString("location"));
			pojo.setLocation_type(row.getString("location_type"));
//			row.getList(i, "tags");
//			pojo.setTags(tags);
			
			videos.add(pojo); // Lets use column 0 since there is only one
									// column
		}

		//
		// Return the list of strings.
		//

		return videos;
	}
}
