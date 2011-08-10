package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.users.User;

public class Wizard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private BlobKey avatar;
	private String avatarUrl;
	private String name;
	
}