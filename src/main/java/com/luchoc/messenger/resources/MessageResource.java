package com.luchoc.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
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

import com.luchoc.messenger.model.Message;
import com.luchoc.messenger.resources.beans.MessageFilterBean;
import com.luchoc.messenger.service.MessageService;

@Path("/messages")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) { 
		if (filterBean.getYear() > 0) { 
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) { 
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		
		return messageService.getAllMessages();
	}
	
	@POST
	public Response addMesage(Message message, @Context UriInfo uriInfo) { 
		Message newMessage = messageService.addMessage(message);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") long messageId) {
		return messageService.removeMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) { 
		return messageService.getMessage(messageId);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() { 
		return new CommentResource(); 
	}
}