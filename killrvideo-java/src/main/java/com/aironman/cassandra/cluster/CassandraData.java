package com.aironman.cassandra.cluster;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

/**
 * DataStax Academy Sample Application
 * 
 * Copyright 2013 DataStax
 * 
 * This is a Singleton class that holds 1 Cassandra session that all requests
 * will share. It has 1 public method to return that session.
 * 
 * 
 * 
 * 
 */

public class CassandraData {

	//
	// A static variable that holds the session. Only one of these will exist
	// for the whole application
	//

	private static Session cassandraSession = null;

	private static String keyspace;
	private static String host;
	
	static {
		Yaml yaml = new Yaml();
		// try( InputStream in = Files.newInputStream( "myCassandraConfig.yml" )
		// ) {
		try (InputStream in = Files.newInputStream(Paths.get("myCassandraConfig.yaml"))) {
			CassandraConfig config = yaml.loadAs(in, CassandraConfig.class);
			System.out.println(config.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			keyspace="killrvideo-java";
			host="localhost";
		}
	}
	/**
	 * Required constructor, but it doesn't need to do anything.
	 */

	public CassandraData() {
		//doing nothing
	}

	/**
	 * 
	 * Return the Cassandra session. When the application starts up, the session
	 * is set to null. When this function is called, it checks to see if the
	 * session is null. If so, it creates a new session, and sets the static
	 * session.
	 * 
	 * All of the DAO classes are subclasses of this
	 * 
	 * @return - a valid cassandra session
	 */

	public static Session getSession() {

		if (cassandraSession == null) {
			cassandraSession = createSession();
		}

		return cassandraSession;

	}

	/**
	 * 
	 * Create a new cassandra Cluster() and Session(). Returns the Session.
	 * 
	 * @return A new Cassandra session
	 */

	protected static Session createSession() {
		Cluster cluster = Cluster.builder().addContactPoint(host)
				.build();
		return cluster.connect(keyspace);
	}
}
