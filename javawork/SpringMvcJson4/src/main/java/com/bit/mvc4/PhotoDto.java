package com.bit.mvc4;

public class PhotoDto {
	private String name;
	private String photo;
	
	//생성자
	public PhotoDto(String name, String photo) {
		super();
		this.name = name;
		this.photo = photo;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
