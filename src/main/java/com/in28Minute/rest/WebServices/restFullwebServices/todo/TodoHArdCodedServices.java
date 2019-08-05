package com.in28Minute.rest.WebServices.restFullwebServices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHArdCodedServices {
    private static List<Todo> todos = new ArrayList();
    
    private static Long idCounter=(long)0;
    
    static{
    	todos.add(new Todo(++idCounter, "in28Minutes", "Learn to dance", new Date(), false));
    	todos.add(new Todo(++idCounter, "Keshav", "Learn to microServices", new Date(), false));
    	todos.add(new Todo(++idCounter, "Rakesh", "Learn to SpringBoot", new Date(), false));
    	todos.add(new Todo(++idCounter, "Rajiv", "Learn to Java", new Date(), false));
    }
    
    public List<Todo> findAll(){
    	return todos;
    }
    
    public Todo save(Todo todo){
    	if(todo.getId()== -1 || todo.getId()== 0 ){
    		todo.setId(++idCounter);
    		todos.add(todo);
    	}
    	else{
    		deleteById(todo.getId());
    		todos.add(todo);
    	}
    	return todo;
    }
    
    public Todo deleteById(long id){
    	Todo todo = findById(id);
    	if(todo==null)
    		return null;
    	if(todos.remove(todo)){
		return todo;
    	}
    	return null;
    	
    }

	public Todo findById(long id) {
		for(Todo todo: todos){
			if(todo.getId() == id)
				return todo;		
		}
		// TODO Auto-generated method stub
		return null;
	}
}
