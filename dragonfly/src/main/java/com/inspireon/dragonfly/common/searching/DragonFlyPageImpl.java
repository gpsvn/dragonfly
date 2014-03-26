package com.inspireon.dragonfly.common.searching;

import java.util.List;

import org.springframework.data.domain.PageImpl;

public class DragonFlyPageImpl<T> extends PageImpl<T>{

	private static final long serialVersionUID = -3125646909995489498L;

	public DragonFlyPageImpl(List<T> content) {
		super(content);
	}
}
