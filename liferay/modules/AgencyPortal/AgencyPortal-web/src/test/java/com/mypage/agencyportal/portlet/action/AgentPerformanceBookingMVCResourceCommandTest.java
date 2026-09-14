package com.mypage.agencyportal.portlet.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mypage.admin.product.model.MasterGlobalVariable;
import com.mypage.admin.product.service.MasterGlobalVariableLocalServiceUtil;
import com.mypage.agencyportal.dto.BodyDto;
import com.mypage.agencyportal.dto.ClubYearDto;
import com.mypage.agencyportal.dto.PolicyDto;
import com.mypage.agencyportal.dto.ResponseDto;
import com.mypage.agencyportal.dto.axamiles.GroupTripRewardDto;
import com.mypage.agencyportal.dto.axamiles.HasNameValueDto;
import com.mypage.agencyportal.dto.axamiles.TripRewardDto;
import com.mypage.agencyportal.helpers.ActionHelpers;
import com.mypage.agencyportal.model.AgentToken;
import com.mypage.agencyportal.service.AgentTokenLocalService;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public class AgentPerformanceBookingMVCResourceCommandTest {

	private AgentPerformanceBookingMVCResourceCommand command;
	private ActionHelpers mockHelpers;
	private AgentTokenLocalService mockTokenService;
	private AgentToken mockAgentToken;
	private AgentToken mockRenewedToken;

	@BeforeEach
	void setUp() throws Exception {
		command = new AgentPerformanceBookingMVCResourceCommand();
		mockHelpers = mock(ActionHelpers.class);
		mockTokenService = mock(AgentTokenLocalService.class);
		mockAgentToken = mock(AgentToken.class);
		mockRenewedToken = mock(AgentToken.class);

		Field helpersField = AgentPerformanceBookingMVCResourceCommand.class.getDeclaredField("helpers");
		helpersField.setAccessible(true);
		helpersField.set(null, mockHelpers);

		Field tokenField = AgentPerformanceBookingMVCResourceCommand.class.getDeclaredField("_agentTokenLocalService");
		tokenField.setAccessible(true);
		tokenField.set(command, mockTokenService);

		Field binderField = AgentPerformanceBookingMVCResourceCommand.class.getDeclaredField("agencyBinderNo");
		binderField.setAccessible(true);
		binderField.set(null, "BINDER001");

		Field apiUrlField = AgentPerformanceBookingMVCResourceCommand.class.getDeclaredField("apiURL");
		apiUrlField.setAccessible(true);
		apiUrlField.set(null, "http://test.url");
	}

	@AfterEach
	void tearDown() throws Exception {
		Field helpersField = AgentPerformanceBookingMVCResourceCommand.class.getDeclaredField("helpers");
		helpersField.setAccessible(true);
		helpersField.set(null, new ActionHelpers());
	}

	@Test
	void testGetClub_shouldSetMilesFromCollectedByAgentAmt() throws Exception {
		BodyDto mockRequestBody = mock(BodyDto.class);
		ResponseDto<BodyDto> mockResponse = mock(ResponseDto.class);
		BodyDto mockResponseBody = mock(BodyDto.class);
		PolicyDto mockPolicy = mock(PolicyDto.class);

		when(mockHelpers.setupRequestBody(eq(BodyDto.class), anyString(), anyString(), isNull()))
			.thenReturn(mockRequestBody);

		when(mockHelpers.getConfig("com.mypage.agent.config.eipApiPolicyManagementUrl"))
			.thenReturn("http://test.url");

		when(mockHelpers.setupCallAPI(anyString(), anyString(), any(Type.class), any(), any(HttpServletRequest.class)))
			.thenAnswer(invocation -> mockResponse);

		when(mockResponse.getStatusCode()).thenReturn(200);
		when(mockResponse.getBody()).thenReturn(mockResponseBody);

		List<PolicyDto> policies = new ArrayList<>();
		policies.add(mockPolicy);
		when(mockResponseBody.getPolicies()).thenReturn(policies);

		when(mockPolicy.getGeneralRk()).thenReturn("Club A");
		when(mockPolicy.getChangeEffectiveFromDttm()).thenReturn("2024");
		when(mockPolicy.getCurrencyCD()).thenReturn("IDR");
		when(mockPolicy.getPremiumAMT()).thenReturn(1000.0);
		when(mockPolicy.getCollectedByAgentAmt()).thenReturn(500.0);

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		List<ClubYearDto> result = command.getClub(mockRequest);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(500.0, result.get(0).getMiles());
		assertEquals("Club A", result.get(0).getClub());
		assertEquals("IDR", result.get(0).getCurrency());
		assertEquals(1000.0, result.get(0).getAmount());
		assertEquals(2024, result.get(0).getYear());
	}

	@Test
	void testGetTripReward_shouldSetBonusPlusFieldsWhenResponseHasRewardTierBonusPlusAndTripAllowanceBonusPlus() throws Exception {
		com.mypage.agencyportal.dto.axamiles.BodyDto mockRequestBody =
			mock(com.mypage.agencyportal.dto.axamiles.BodyDto.class);

		ResponseDto<com.mypage.agencyportal.dto.axamiles.BodyDto> mockResponse =
			mock(ResponseDto.class);

		com.mypage.agencyportal.dto.axamiles.BodyDto mockResponseBody =
			mock(com.mypage.agencyportal.dto.axamiles.BodyDto.class);

		com.mypage.agencyportal.dto.axamiles.PolicyDto mockPolicy =
			mock(com.mypage.agencyportal.dto.axamiles.PolicyDto.class);

		com.mypage.agencyportal.dto.axamiles.PartyDetailsDto mockPartyDetail =
			mock(com.mypage.agencyportal.dto.axamiles.PartyDetailsDto.class);

		MasterGlobalVariable mockGlobalVar = mock(MasterGlobalVariable.class);

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);

		when(mockHelpers.setupRequestBody(
			eq(com.mypage.agencyportal.dto.axamiles.BodyDto.class),
			anyString(), anyString(), anyString()
		)).thenReturn(mockRequestBody);

		when(mockHelpers.setupCallAPI(
			anyString(), anyString(), any(Type.class), any(), any(HttpServletRequest.class)
		)).thenAnswer(invocation -> mockResponse);

		when(mockHelpers.isParsableToDouble("500.0")).thenReturn(true);

		when(mockResponse.getStatusCode()).thenReturn(200);
		when(mockResponse.getBody()).thenReturn(mockResponseBody);
		when(mockResponseBody.getPolicy()).thenReturn(mockPolicy);
		when(mockPolicy.getAgencyBinderNo()).thenReturn("BINDER001");

		List<com.mypage.agencyportal.dto.axamiles.PartyDetailsDto> partyDetails = new ArrayList<>();
		partyDetails.add(mockPartyDetail);
		when(mockPolicy.getHasPartyDetailsIn()).thenReturn(partyDetails);

		List<com.mypage.agencyportal.dto.axamiles.HasNameValueDto> nameValues = new ArrayList<>();

		HasNameValueDto gwpData = mock(HasNameValueDto.class);
		when(gwpData.getName()).thenReturn("GWP Test");
		when(gwpData.getValue()).thenReturn("100");
		nameValues.add(gwpData);

		HasNameValueDto rewardTierBonusPlus = mock(HasNameValueDto.class);
		when(rewardTierBonusPlus.getName()).thenReturn("RewardTierBonusPlus");
		when(rewardTierBonusPlus.getValue()).thenReturn("BonusPlusValue");
		nameValues.add(rewardTierBonusPlus);

		HasNameValueDto tripAllowanceBonusPlus = mock(HasNameValueDto.class);
		when(tripAllowanceBonusPlus.getName()).thenReturn("TripAllowanceBonusPlus");
		when(tripAllowanceBonusPlus.getValue()).thenReturn("500.0");
		nameValues.add(tripAllowanceBonusPlus);

		when(mockPartyDetail.getHasNameValue()).thenReturn(nameValues);
		when(mockPartyDetail.getPartyStatus()).thenReturn("eligible");
		when(mockPartyDetail.getPartyRK()).thenReturn("1000");
		when(mockPartyDetail.getPartyTypeCD()).thenReturn("Gold");
		when(mockPartyDetail.getParentPartyCD()).thenReturn("1");

		MasterGlobalVariable mockGlobalVariable = mock(MasterGlobalVariable.class);
		when(mockGlobalVariable.getName()).thenReturn("endpoint miles");
		when(mockGlobalVariable.getActive()).thenReturn(1);
		when(mockGlobalVariable.getValue()).thenReturn("http://miles.url");

		try (MockedStatic<MasterGlobalVariableLocalServiceUtil> mgvMock =
				Mockito.mockStatic(MasterGlobalVariableLocalServiceUtil.class)) {

			mgvMock.when(() -> MasterGlobalVariableLocalServiceUtil.getActiveGlobalVariableByGroup("Scorecard"))
				.thenReturn(Arrays.asList(mockGlobalVariable));

			TripRewardDto result = command.getTripReward(mockRequest);

			assertNotNull(result);
			assertEquals("BonusPlusValue", result.getPaxBonus());
			assertEquals(500.0, result.getTripAllowancePlus());
			assertEquals("Gold", result.getTier());
			assertEquals("1", result.getRank());
			assertEquals(0.0, result.getAllowance());
			assertEquals(0.0, result.getTripAllowance());
			assertEquals(500.0, result.getTripAllowancePlus());

			assertNotNull(result.getTerms());
			assertEquals(2, result.getTerms().size());
		}
	}
}
