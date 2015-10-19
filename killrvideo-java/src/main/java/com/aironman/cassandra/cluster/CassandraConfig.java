package com.aironman.cassandra.cluster;

public class CassandraConfig {

	public String keyspace;
	public String host;
	public String getKeyspace() {
		return keyspace;
	}
	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "CassandraConfig [keyspace=" + keyspace + ", host=" + host + "]";
	}
	
	
}
