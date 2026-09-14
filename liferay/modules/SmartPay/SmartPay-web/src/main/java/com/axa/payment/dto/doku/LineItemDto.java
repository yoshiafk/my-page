package com.axa.payment.dto.doku;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LineItemDto {
	private String id;
    private String name;
    private int quantity;
    private int price;
    private String sku;
    private String category;
    private String url;
    @SerializedName("image_url")
    private String imageUrl;
    private String type;
    
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
