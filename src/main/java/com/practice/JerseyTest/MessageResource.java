package com.practice.JerseyTest;

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

import com.practice.JerseyTest.model.Message;
import com.practice.JerseyTest.model.Message;
import com.practice.JerseyTest.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageservice=new MessageService();

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		
		return messageservice.getAllMessages();
	}

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessagesById(@PathParam("messageId") String id){
		
		return messageservice.getMessageById(id);
	}
	
	  @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Message addMessage( Message message) {
	        
		  messageservice.addMessage(message);
	        return message;
	    }
	    
	    @PUT
	    @Path("{messageid}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Message updateMessagebyId( Message message, @PathParam("messageid")  String id) {
	        
	    	messageservice.updateMessage(message, id);
	        return message;
	    }
	    
	    @DELETE
	    @Path("{messageid}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    public void DeleteMessagebyId(@PathParam("messageid")  String id) {
	        
	    	messageservice.deleteMessageById(id);
	    }

}
