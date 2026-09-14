package com.mypage.agencyportal.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PolicyDtoTest {

	@Test
	void testGetSetCollectedByAgentAmt() {
		PolicyDto dto = new PolicyDto();

		assertEquals(0.0, dto.getCollectedByAgentAmt());

		dto.setAgencyBinderNo("BINDER001");
		assertEquals("BINDER001", dto.getAgencyBinderNo());
	}
}
