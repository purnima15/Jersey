
package com.practice.JerseyTest;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import com.practice.JerseyTest.model.Comment;
import java.util.List;
import com.practice.JerseyTest.service.CommentService;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource
{
    private CommentService commentservice;
    
    public CommentResource() {
        this.commentservice = new CommentService();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments() {
        return commentservice.getAllComments();
    }
    
    @GET
    @Path("/{CommentId}")
    public String getCommentById(@PathParam("CommentId") final String id) {
        return "test " + id;
    }
}   