package com.inspireon.dragonfly.common.util;

import java.util.Date;

import com.github.slugify.Slugify;

/**
 * 
 * @author Phuong
 *
 */
public class URLUtils {

	
	public static String slug(String url){
		String slug = new Slugify(true).slugify(url.toLowerCase().replace("đ", "d"));
		if(slug==null || slug.length() <1 || slug.trim().length()==0){
			slug = "" + new Date().getTime();
		}
		return slug;
	}
}
