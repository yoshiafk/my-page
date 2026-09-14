package com.mypage.agencyportal.dto.axamiles;

import java.util.List;

public class TripRewardDto {
	private List<GroupTripRewardDto> terms;
	private String status;
	private String tier;
	private String pax;
	private String paxBonus;
	private String rank;
	private double allowance;
	private double tripAllowance;
	private double tripAllowancePlus;
	
	public List<GroupTripRewardDto> getTerms() {
		return terms;
	}
	
	public void setTerms(List<GroupTripRewardDto> terms) {
		this.terms = terms;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTier() {
		return tier;
	}
	
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	public String getPax() {
		return pax;
	}
	
	public void setPax(String pax) {
		this.pax = pax;
	}

	public String getPaxBonus() {
		return paxBonus;
	}

	public void setPaxBonus(String paxBonus) {
		this.paxBonus = paxBonus;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public double getAllowance() {
		return allowance;
	}
	
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
	public double getTripAllowance() {
		return tripAllowance;
	}
	
	public void setTripAllowance(double tripAllowance) {
		this.tripAllowance = tripAllowance;
	}

	public double getTripAllowancePlus() {
		return tripAllowancePlus;
	}

	public void setTripAllowancePlus(double tripAllowancePlus) {
		this.tripAllowancePlus = tripAllowancePlus;
	}
}
