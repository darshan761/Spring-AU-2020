package com.springAU.RESTAssignment;

import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// root path 
@Path("/users")
public class Controller {
	
	// list of users
	public static List<User> users = new ArrayList<>();
	
	
	// to get all the users 
	@GET
	@Produces("application/json")
	public List<User> getAllUsers() {
		return users;	
	}
	
	
	// to create user with id at users/create/id
		@POST
		@Path("create/{id}")
	    @Consumes("application/json")
		@Produces("application/json")
	    public User createUser(@PathParam("id") int id, User u) {

			if(u.name==null && u.userId==0) throw new NotFoundException();
			else users.add(u);
			return u;
		}
	
		
	// to update user with id at users/update/id
	@PUT
	@Path("update/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public String updateUser(@PathParam("id") int id, User u) throws NotFoundException{
		
		if(u.name==null && u.userId==0) throw new NotFoundException();
		
		for(User user:users) {
			if(user.userId == id) {	
				users.remove(user); // removes old user
				users.add(u); // adds updated user
				break;
			}
		}
		
		return "Updated object:"+u.toString();
	}
		
	
	// to delete user with id at users/delete/id
	@DELETE
	@Path("delete/{id}")
	@Produces("application/json")
	public User deleteUser(@PathParam("id") int id) throws NotFoundException {
		
		User removed = new User();
		for(User u:users) {
			if(u.userId == id) {
				removed = u;
				users.remove(u); // removes user object
				break;
			}
		}
		return removed;
	}
		
}