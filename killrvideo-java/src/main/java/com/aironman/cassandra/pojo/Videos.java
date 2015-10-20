package com.aironman.cassandra.pojo;

import java.util.Set;
import java.util.TreeSet;

public class Videos {

	/***
	 * videoid uuid,
    userid uuid,
    name text,
    description text,
    location text,
    location_type int,
    preview_image_location text,
    tags set<text>,
    added_date timestamp,
	 */
	private String userid;
	private String name;
	private String description;
	private String location;
	private String location_type;
	private String preview_image_location;
	private Set<String> tags = new TreeSet<String>();
	private String added_date;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public String getPreview_image_location() {
		return preview_image_location;
	}
	public void setPreview_image_location(String preview_image_location) {
		this.preview_image_location = preview_image_location;
	}
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	@Override
	public String toString() {
		return "Videos [userid=" + userid + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", location_type=" + location_type + ", preview_image_location=" + preview_image_location + ", tags="
				+ tags + ", added_date=" + added_date + "]";
	}
	
	
}
