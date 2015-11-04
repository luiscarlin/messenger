package com.luchoc.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.luchoc.messenger.model.Profile;
import com.luchoc.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() { 
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) { 
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") long profileId, Profile profile) {
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileId}")
	public Profile deleteProfile(@PathParam("profileId") long profileId) {
		return profileService.removeProfile(profileId);
	}
	
	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") long profileId) { 
		return profileService.getProfile(profileId);
	}
}