package com.inspireon.dragonfly.persistence;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inspireon.dragonfly.common.util.ImageProperty;
import com.inspireon.dragonfly.common.util.ImageUtils;
import com.inspireon.dragonfly.model.domain.image.ImageGroup;
import com.inspireon.dragonfly.model.domain.image.ImageGroupRepo;
import com.inspireon.dragonfly.model.domain.user.User;
import com.inspireon.dragonfly.model.domain.user.UserRepo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
public class ImageGroupRepoTest {

	@Autowired
	ImageGroupRepo imageGroupRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Test 
	@Ignore
	public void generareDefaultImage() {
		ImageGroup defaultAvatar = ImageGroup.defaultAvatarImageGroup();
		ImageGroup defaultFeatured = ImageGroup.defaultFeturedImageGroup();
		if (imageGroupRepo.findByFileName(defaultAvatar.name()) == null) {
			imageGroupRepo.store(defaultAvatar);
		}
		if (imageGroupRepo.findByFileName(defaultFeatured.name()) == null) {
			imageGroupRepo.store(defaultFeatured);
		}		
	}
	
	@Ignore
	@Test
	public void findByName(){
		
		String fileName = ImageUtils.generateName();
		String filePath = ImageUtils.generateDirectory() + "/" + fileName + ".jpeg";
		
		// Prepare data
		ImageGroup imageGroup = new ImageGroup(fileName, filePath, "jpeg", null, null, null, null);  
		imageGroupRepo.store(imageGroup);		
			
		// Verify insert image successfully
		ImageGroup newImage = imageGroupRepo.findByFileName(fileName);
		Assert.assertNotNull(newImage);
		
		Assert.assertEquals(newImage.name(), fileName);
		Assert.assertEquals(newImage.path(), filePath);
		Assert.assertEquals(newImage.type(), "jpeg");		
		Assert.assertNotNull(newImage.createdDate());
		
	    // Roll back data
		imageGroupRepo.remove(imageGroup);   
	}		
	
	@Ignore
	@Test
	public void resizeAllOldImages() throws IOException {
		String directory_path = "E:\\test\\images";
		File directory_file = new File(directory_path);
		Set<File> set = new HashSet<File>();
		traversal(directory_file, set);		
		
		for(File directory: set) {
			File full_file = getFile(directory, "full");
			File small_file = getFile(directory, "small");
			File original_file = getFile(directory, "original");
			
			if (full_file != null) {
				//is content
				ImageUtils.createAndResize(original_file.getAbsolutePath(), ImageProperty.IMAGE_NAME_FULL, ImageProperty.FULL); //small
				System.out.println("success resize Image Content: " + directory.getAbsolutePath());
			} else if (small_file != null) {
				User user = userRepo.findUserByAvatar(directory.getName());
				
				if (user != null) {
					ImageUtils.createAndResize(original_file.getAbsolutePath(), ImageProperty.IMAGE_NAME_SMALL, ImageProperty.AVATAR_SMALL, true); //small
					ImageUtils.createAndResize(original_file.getAbsolutePath(), ImageProperty.IMAGE_NAME_LARGE, ImageProperty.AVATAR_LARGE, true); // large
					System.out.println("success resize Image Avatar: " + directory.getAbsolutePath());
				} else {
					ImageUtils.createAndResize(original_file.getAbsolutePath(), ImageProperty.IMAGE_NAME_SMALL, ImageProperty.FEATURED_SMALL); //small
					ImageUtils.createAndResize(original_file.getAbsolutePath(), ImageProperty.IMAGE_NAME_LARGE, ImageProperty.FEATURED_LARGE); // large
					System.out.println("success resize Image Featured: " + directory.getAbsolutePath());
				}
			}
		}
		
	}
	
	public File getFile(File directory, String name) {
		for (File subFile : directory.listFiles()) {
			if (subFile.isFile()) {
				if (subFile.getName().contains(name)) {
					return subFile;
				}						
			}
		}
		return null;		
	}
	
	public void traversal(File file, Set<File> set) {
		if (file != null && file.exists()) {
			if (file.isDirectory()) {
				for (File subFile : file.listFiles())
					traversal(subFile, set);
			} else {
				set.add(new File(file.getParent()));				
			}
		}
	}
}
