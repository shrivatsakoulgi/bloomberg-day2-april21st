package com.bloomberg.springbootdemo.entity;

public class Share {
	private String shareName;
	private double sharePrice;
	private double equityDebtRatio;
	private double totalInvestmentsInCrores;

	public Share() {

	}

	public Share(String shareName, double sharePrice, double equityDebtRatio, double totalInvestmentsInCrores) {
		this.shareName = shareName;
		this.sharePrice = sharePrice;
		this.equityDebtRatio = equityDebtRatio;
		this.totalInvestmentsInCrores = totalInvestmentsInCrores;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public double getEquityDebtRatio() {
		return equityDebtRatio;
	}

	public void setEquityDebtRatio(double equityDebtRatio) {
		this.equityDebtRatio = equityDebtRatio;
	}

	public double getTotalInvestmentsInCrores() {
		return totalInvestmentsInCrores;
	}

	public void setTotalInvestmentsInCrores(double totalInvestmentsInCrores) {
		this.totalInvestmentsInCrores = totalInvestmentsInCrores;
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	@Override
	public String toString() {
		return "Share [shareName=" + shareName + ", sharePrice=" + sharePrice + ", equityDebtRatio=" + equityDebtRatio
				+ ", totalInvestmentsInCrores=" + totalInvestmentsInCrores + "]";
	}

	
	
	

}
