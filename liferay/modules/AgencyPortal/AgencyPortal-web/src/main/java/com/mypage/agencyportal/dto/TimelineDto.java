package com.mypage.agencyportal.dto;

import java.util.Date;

public class TimelineDto {

	private Long timelineId;
	private Date createDate;
	private String userName;
	private String textStatus;
	private Long timelineFileEntryId;
	private Long profileFileEntryId;
	private String imgUrlTimeline;
	private String imgUrlAvatar;
	private String videoUrl;

	public Long getTimelineId() {
		return timelineId;
	}

	public void setTimelineId(Long timelineId) {
		this.timelineId = timelineId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTextStatus() {
		return textStatus;
	}

	public void setTextStatus(String textStatus) {
		this.textStatus = textStatus;
	}

	public String getImgUrlTimeline() {
		return imgUrlTimeline;
	}

	public void setImgUrlTimeline(String imgUrlTimeline) {
		this.imgUrlTimeline = imgUrlTimeline;
	}

	public String getImgUrlAvatar() {
		return imgUrlAvatar;
	}

	public void setImgUrlAvatar(String imgUrlAvatar) {
		this.imgUrlAvatar = imgUrlAvatar;
	}

	public Long getTimelineFileEntryId() {
		return timelineFileEntryId;
	}

	public void setTimelineFileEntryId(Long timelineFileEntryId) {
		this.timelineFileEntryId = timelineFileEntryId;
	}

	public Long getProfileFileEntryId() {
		return profileFileEntryId;
	}

	public void setProfileFileEntryId(Long profileFileEntryId) {
		this.profileFileEntryId = profileFileEntryId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

}
