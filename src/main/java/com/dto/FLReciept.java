package com.dto;

public class FLReciept {
	private String letterNumber;
	private String referenceNumber;
	private String subject;
	private String correspondenceNumber;
	private long  modeId;
	private boolean isVip;
	
	public String getLetterNumber() {
		return letterNumber;
	}
	public void setLetterNumber(String letterNumber) {
		this.letterNumber = letterNumber;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getModeId() {
		return modeId;
	}
	public void setModeId(long modeId) {
		this.modeId = modeId;
	}
	public String getCorrespondenceNumber() {
		return correspondenceNumber;
	}
	public void setCorrespondenceNumber(String correspondenceNumber) {
		this.correspondenceNumber = correspondenceNumber;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
}
