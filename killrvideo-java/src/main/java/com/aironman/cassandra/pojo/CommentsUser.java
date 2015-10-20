package com.aironman.cassandra.pojo;

public class CommentsUser {

	/***
	 * userid uuid,
    commentid timeuuid,
    videoid uuid,
    comment text,
	 */
	private String userid;
	private String commentid;
	private String videoid;
	private String comment;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getVideoid() {
		return videoid;
	}
	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "CommentsUser [userid=" + userid + ", commentid=" + commentid + ", videoid=" + videoid + ", comment="
				+ comment + "]";
	}
	
}
