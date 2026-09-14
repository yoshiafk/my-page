package com.mypage.agencyportal.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClubYearDtoTest {

	@Test
	void testGetSetMiles() {
		ClubYearDto dto = new ClubYearDto();

		dto.setMiles(123.45);
		assertEquals(123.45, dto.getMiles());

		dto.setMiles(0.0);
		assertEquals(0.0, dto.getMiles());

		dto.setMiles(-99.99);
		assertEquals(-99.99, dto.getMiles());
	}
}
