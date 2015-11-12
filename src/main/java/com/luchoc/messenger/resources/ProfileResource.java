package com.luchoc.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
	public Response addProfile(Profile profile, @Context UriInfo uriInfo) { 
		Profile newProfile = profileService.addProfile(profile);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newProfile.getId())).build();
		return Response.created(uri)
				.entity(newProfile)
				.build();
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String profileName) {
		return profileService.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) { 
		return profileService.getProfile(profileName);
	}
}