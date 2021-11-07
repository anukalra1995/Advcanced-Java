package com.nagarro.imagemanage.interfaces;

import java.util.List;

import com.nagarro.imagemanage.models.ImageDetails;


public interface ImageManage {
	
	public void addImages(ImageDetails image);
	
	public List<ImageDetails> getAllImageOfUser(String username);
	
	public void deleteImage(String imageid);
	
	public void updateImage(ImageDetails image);
}
