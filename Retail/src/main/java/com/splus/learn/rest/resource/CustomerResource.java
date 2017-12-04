package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Customer;
import com.splus.learn.rest.service.CustomerService;

@Path("/customer")
public class CustomerResource {

	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCustomer(Customer customer) throws SQLException {
		CustomerService showService = new CustomerService();
		ApiResponse response = showService.customerShow(customer);
		return Response.status(200).entity(response).build();

	}

	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Customer customer) throws SQLException {
		CustomerService showService = new CustomerService();
		ApiResponse response = showService.customerById(customer);
		return Response.status(200).entity(response).build();

	}
}
