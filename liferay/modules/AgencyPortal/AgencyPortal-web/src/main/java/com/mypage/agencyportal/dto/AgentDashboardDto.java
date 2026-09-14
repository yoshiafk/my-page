package com.mypage.agencyportal.dto;

import java.util.List;

public class AgentDashboardDto {

	private LocationDto agentLocation;

	private List<TimelineDto> timelineUser;

	public LocationDto getAgentLocation() {
		return agentLocation;
	}

	public void setAgentLocation(LocationDto agentLocation) {
		this.agentLocation = agentLocation;
	}

	public List<TimelineDto> getTimelineUser() {
		return timelineUser;
	}

	public void setTimelineUser(List<TimelineDto> timelineUser) {
		this.timelineUser = timelineUser;
	}

}
