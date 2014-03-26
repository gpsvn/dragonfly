package com.inspireon.dragonfly.persistence.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.inspireon.dragonfly.model.domain.image.ImageGroup;
import com.inspireon.dragonfly.model.domain.image.ImageGroupRepo;
import com.inspireon.dragonfly.persistence.BaseRepoImpl;

@Repository
public class ImageGroupRepoImpl extends BaseRepoImpl<ImageGroup, String> implements ImageGroupRepo{

	@Override
	public ImageGroup findByFileName(String fileName) {
		return getTemplate().findOne(
				new Query().addCriteria(Criteria.where("name").is(fileName)), ImageGroup.class);
	}
	
}
