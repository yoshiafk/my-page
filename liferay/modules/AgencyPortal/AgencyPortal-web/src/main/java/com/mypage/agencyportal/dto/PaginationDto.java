package com.mypage.agencyportal.dto;

public class PaginationDto {
	private int itemPerPage;
	private int page;
	private int totalItem;
	private int totalPage;
	
	public int getItemPerPage() {
		return itemPerPage;
	}
	
	public void setItemPerPage(int itemPerPage) {
		this.itemPerPage = itemPerPage;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalItem() {
		return totalItem;
	}
	
	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
