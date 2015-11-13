package com.luchoc.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.luchoc.messenger.database.DatabaseClass;
import com.luchoc.messenger.exception.DataNotFoundException;
import com.luchoc.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages(); 
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year) { 
		List<Message> messagesForYear = new ArrayList<>(); 
		
		Calendar cal = Calendar.getInstance(); 
		
		for (Message message : messages.values()) { 
			cal.setTime(message.getCreated());
			
			if (cal.get(Calendar.YEAR) == year) { 
				messagesForYear.add(message); 
			}
		}
		return messagesForYear; 
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) { 
		List<Message> list = new ArrayList<Message>(messages.values()); 
		
		if (start + size > list.size())  { 
			return list;
		}
		
		return list.subList(start, start  + size); 
	
	}
	
	public Message getMessage(long id) { 
		Message message = messages.get(id);
		if (message == null) { 
			throw new DataNotFoundException("Message with id " + id + " was not found");
		}
		return message;
	}
		
	public Message addMessage(Message message) { 
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) { 
		if (message.getId() <= 0) { 
			return null; 
		}
		messages.put(message.getId(), message); 
		return message; 
	}
	
	public Message removeMessage(long id) { 
		return messages.remove(id); 
	}
}