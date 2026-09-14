package com.mypage.agencyportal.dto.axamiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class TripRewardDtoTest {

	@Test
	void testGetSetPaxBonus() {
		TripRewardDto dto = new TripRewardDto();

		assertNull(dto.getPaxBonus());

		dto.setPaxBonus("BonusPlusValue");
		assertEquals("BonusPlusValue", dto.getPaxBonus());

		dto.setPaxBonus(null);
		assertNull(dto.getPaxBonus());
	}

	@Test
	void testGetSetTripAllowancePlus() {
		TripRewardDto dto = new TripRewardDto();

		assertEquals(0.0, dto.getTripAllowancePlus());

		dto.setTripAllowancePlus(500.0);
		assertEquals(500.0, dto.getTripAllowancePlus());

		dto.setTripAllowancePlus(0.0);
		assertEquals(0.0, dto.getTripAllowancePlus());
	}
}
