package com.mypage.agencyportal.dto;

public class SalesToolsDto {
	private String title;
	private String description;
	private String category;
	private String dateFormat;
	private String extension;
	private String filePath;
	private String target;
	private Long fileEntryId;
	private Long salesToolsId;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}
	
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	public long getSalesToolsId() {
		return salesToolsId;
	}
	
	public void setSalesToolsId(long salesToolsId) {
		this.salesToolsId = salesToolsId;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFileEntryId() {
		return fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		this.fileEntryId = fileEntryId;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
