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

/**
 * This class is for User resource
 * 
 * @author Nazish.Khatoon
 *
 */

@Path("/user")
public class UserResource {
	/**
	 * 
	 * @param msg
	 * @return
	 */
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	/**
	 * 
	 * @param user
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response login(User user) throws SQLException {
		UserService loginService = new UserService();
		ApiResponse response = loginService.login(user);
		return Response.status(200).entity(response).build();

	}
}
