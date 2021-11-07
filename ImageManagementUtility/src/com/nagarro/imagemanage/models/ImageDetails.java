package com.nagarro.imagemanage.models;

import javax.persistence.*;

@Entity
@Table(name = "image_details")
public class ImageDetails {
	
	@Id
	@Column(name = "image_id")
	private int imageId;
	

	@Column(name = "image_name" ,columnDefinition = "blob")
	private String imageName;
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name = "image_size")
	private double imageSize;
	
	@ManyToOne
	private User user;
	
	public ImageDetails() {}
	
	public ImageDetails(int imageId,String imageName,byte[] image,double imageSize, User user) {
		
		this.image = image;
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageSize= imageSize;
		this.user=user;
		
	}
	
	public ImageDetails(int imageId,String imageName,byte[] image,double imageSize) {
		
		this.image = image;
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageSize= imageSize;
		
		
	}
	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getImageSize() {
		return imageSize;
	}

	public void setImageSize(double imageSize) {
		this.imageSize = imageSize;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
