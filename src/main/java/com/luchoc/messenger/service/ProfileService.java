package com.luchoc.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.luchoc.messenger.database.DatabaseClass;
import com.luchoc.messenger.model.Message;
import com.luchoc.messenger.model.Profile;

public class ProfileService {
	
	private Map<Long, Profile> profiles = DatabaseClass.getProfiles(); 
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(long id) { 
		return profiles.get(id); 
	}
	
	public Profile addProfile(Profile profile) { 
		profile.setId(profiles.size() + 1);
		profile.setCreated(new Date());
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) { 
		if (profile.getId() <= 0) { 
			return null; 
		}
		profiles.put(profile.getId(), profile); 
		return profile; 
	}
	
	public Profile removeProfile(long id) { 
		return profiles.remove(id); 
	}
}