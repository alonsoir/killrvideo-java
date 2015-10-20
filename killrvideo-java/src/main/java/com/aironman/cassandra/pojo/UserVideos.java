package com.aironman.cassandra.pojo;

public class UserVideos {

	/***
	 * userid uuid,
    added_date timestamp,
    videoid uuid,
    name text,
    preview_image_location text,
	 */
	private String userid;
	private String added_date;
	private String videoid;
	private String name;
	private String preview_image_location;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAdded_date() {
		return added_date;
	}
	public void setAdded_date(String added_date) {
		this.added_date = added_date;
	}
	public String getVideoid() {
		return videoid;
	}
	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview_image_location() {
		return preview_image_location;
	}
	public void setPreview_image_location(String preview_image_location) {
		this.preview_image_location = preview_image_location;
	}
	@Override
	public String toString() {
		return "UserVideos [userid=" + userid + ", added_date=" + added_date + ", videoid=" + videoid + ", name=" + name
				+ ", preview_image_location=" + preview_image_location + "]";
	}
	
	
}
