package com.mypage.agencyportal.dto.axamiles;

import java.util.List;

public class CustomerInformationDto {
	List<CommunicateMessageDto> haveCommunicatedMessage;

	public List<CommunicateMessageDto> getHaveCommunicatedMessage() {
		return haveCommunicatedMessage;
	}

	public void setHaveCommunicatedMessage(List<CommunicateMessageDto> haveCommunicatedMessage) {
		this.haveCommunicatedMessage = haveCommunicatedMessage;
	}
}
