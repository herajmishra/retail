package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.User;
import com.splus.learn.rest.service.UserService;

@Path("/user")
public class UserResource {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response login(User user) throws SQLException {
		UserService loginService = new UserService();
		ApiResponse response = loginService.login(user);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method insert a new user in the database
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(User user) throws SQLException {
		UserService showService = new UserService();
		ApiResponse response = showService.saveUser(user);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method updates the data for a userId
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(User user) throws SQLException {
		UserService showService = new UserService();
		ApiResponse response = showService.updateUser(user);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method logically delete's an entry from the user database matching with
	 * the userId
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(User user) throws SQLException {
		UserService showService = new UserService();
		ApiResponse response = showService.deleteUser(user);
		return Response.status(200).entity(response).build();

	}
}
