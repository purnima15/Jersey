package com.practice.JerseyTest;

import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import com.practice.JerseyTest.model.Profile;
import com.practice.JerseyTest.service.ProfileService;
import javax.ws.rs.Path;

@Path("/profiles")
public class ProfileResource
{
    ProfileService profileservice;
    
    public ProfileResource() {
        this.profileservice = new ProfileService();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfile() {
        return  profileservice.getAllProfiles();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{profId}")
    public Profile getProfileById(@PathParam("profId")  String id) {
        return profileservice.getProfileById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(final Profile profile) {
        
    	profileservice.addProfile(profile);
        return profile;
    }
    
    @PUT
    @Path("{profId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile updateProfilebyId(final Profile profile, @PathParam("profId")  String id) {
        
    	profileservice.updateProfile(profile, id);
        return profile;
    }
    
    @DELETE
    @Path("{profId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void DeleteProfilebyId(@PathParam("profId")  String id) {
        
    	profileservice.deleteProfileById(id);
    }
}

