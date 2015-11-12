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

import com.luchoc.messenger.model.Comment;
import com.luchoc.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService(); 
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) { 
		return commentService.getAllComments(messageId); 
	}
	
	@POST
	public Response addComment(@PathParam("messageId") long messageId, @Context UriInfo uriInfo, Comment comment) { 
		Comment newComment = commentService.addComment(messageId, comment); 
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newComment.getId())).build();
		return Response.created(uri)
				.entity(newComment)
				.build();
	}
	
	@PUT 
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) { 
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment); 
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) { 
		return commentService.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) { 
		return commentService.getComment(messageId, commentId);
	}
}