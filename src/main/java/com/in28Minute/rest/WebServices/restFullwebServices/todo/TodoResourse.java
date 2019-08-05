package com.in28Minute.rest.WebServices.restFullwebServices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResourse {
	
	@Autowired
	private TodoHArdCodedServices todoHArdCodedServices;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return todoHArdCodedServices.findAll();	
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodos(@PathVariable String username, @PathVariable long id){
		return todoHArdCodedServices.findById(id);	
	}
	
	//Delete/users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodos(@PathVariable String username ,@PathVariable long id){
		Todo todo = todoHArdCodedServices.deleteById(id);
		if(todo != null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo>updateTodo(
			@PathVariable String username ,@PathVariable long id, @RequestBody Todo todo){
		Todo todoUpdate = todoHArdCodedServices.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void>updateTodo(
			@PathVariable String username , @RequestBody Todo todo){
		Todo createdtodo = todoHArdCodedServices.save(todo);
		
		//Get current resource url
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequestUri().
		path("/{id}").buildAndExpand(createdtodo.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}
	
}
