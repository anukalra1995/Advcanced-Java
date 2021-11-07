package com.nagarro.imagemanage.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.imagemanage.hibernateutil.HibernatUtil;
import com.nagarro.imagemanage.interfaces.ImageManage;
import com.nagarro.imagemanage.models.ImageDetails;

public class ImageManagingService implements ImageManage{

	@Override
	public void addImages(ImageDetails image) {
		Transaction tx = null;
		try(Session sessions = HibernatUtil.getSession()) {
			
			tx = sessions.beginTransaction();
			sessions.save(image);
			tx.commit();
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<ImageDetails> getAllImageOfUser(String username) {
		
		Session session = HibernatUtil.getSession();
		Transaction txn = null;
		
		List<ImageDetails> imageList = null;
		
		try {
			
			txn = session.beginTransaction();
			Query q = session.createQuery("from ImageDetails where user.username = '" + username + "'");
			imageList = q.list();
			txn.commit();
		
		} catch (Exception ex) {
			if (txn != null) {
				txn.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return imageList;
	}

	@Override
	public void deleteImage(String imageid) {
		
		Transaction tx = null;
		try(Session session = HibernatUtil.getSession()) {
			
			tx = session.beginTransaction();
			
			ImageDetails img = new ImageDetails();
			img.setImageId(Integer.parseInt(imageid));
			session.delete(img);
			System.out.println("deleted");
			
			tx.commit();
			
		} catch (Exception e) {
			
			if(tx != null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("rawtypes")
	public ImageDetails getImageById(int imageid) {
		Session session = HibernatUtil.getSession();
		Transaction tx = null;
		ImageDetails image = null;
		
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from ImageDetails where imageId = '" + imageid + "'");
			
			image = (ImageDetails) q.uniqueResult();
			
			tx.commit();
			
		} catch (Exception ex) {
			
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return image;

	}

	@Override
	public void updateImage(ImageDetails image) {
		Transaction tx = null;
		try(Session sessions = HibernatUtil.getSession()) {
			
			tx = sessions.beginTransaction();
			sessions.update(image);
			
			tx.commit();
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	
}
