package com.mypage.asmik.model;

import java.util.List;

public class EIPHasPolicyAccount {
	private String premiumAMT;
	private String premiumIndexRt;
    public String getPremiumIndexRt() {
		return premiumIndexRt;
	}

	public void setPremiumIndexRt(String premiumIndexRt) {
		this.premiumIndexRt = premiumIndexRt;
	}

	private List<EIPHasDetailsOfPolicyIn> hasDetailsOfPolicyIn;
    private List<EIPCanHave> canHave;
    private List<EIPHasNameValue> hasNameValue;
    private List<EIPHasDetailsOfRisksIn> hasDetailsOfRisksIn;
    private List<List<DetailsRecord>> hasDetailsRecordIn;

    public List<List<DetailsRecord>> getHasDetailsRecordIn() {
        return hasDetailsRecordIn;
    }

    public void setHasDetailsRecordIn(List<List<DetailsRecord>> hasDetailsRecordIn) {
        this.hasDetailsRecordIn = hasDetailsRecordIn;
    }
    
    public List<EIPHasDetailsOfRisksIn> getHasDetailsOfRisksIn() {
		return hasDetailsOfRisksIn;
	}

	public void setHasDetailsOfRisksIn(List<EIPHasDetailsOfRisksIn> hasDetailsOfRisksIn) {
		this.hasDetailsOfRisksIn = hasDetailsOfRisksIn;
	}

	public List<EIPHasDetailsOfPolicyIn> getHasDetailsOfPolicyIn() {
        return hasDetailsOfPolicyIn;
    }

    public void setHasDetailsOfPolicyIn(List<EIPHasDetailsOfPolicyIn> hasDetailsOfPolicyIn) {
        this.hasDetailsOfPolicyIn = hasDetailsOfPolicyIn;
    }

    public List<EIPCanHave> getCanHave() {
        return canHave;
    }

    public List<EIPHasNameValue> getHasNameValue() {
		return hasNameValue;
	}

	public void setHasNameValue(List<EIPHasNameValue> hasNameValue) {
		this.hasNameValue = hasNameValue;
	}

	public void setCanHave(List<EIPCanHave> canHave) {
        this.canHave = canHave;
    }

	public String getPremiumAMT() {
		return premiumAMT;
	}

	public void setPremiumAMT(String premiumAMT) {
		this.premiumAMT = premiumAMT;
	}
    
}
