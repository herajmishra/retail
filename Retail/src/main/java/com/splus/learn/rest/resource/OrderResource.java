package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Order;
import com.splus.learn.rest.service.OrderService;

/**
 * This is resource class for Order
 * 
 * @author Rishabh.Goel
 *
 */
@Path("/order")
public class OrderResource {
	/**
	 * This method returns all the orders present in the database
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getOrder(Order order) throws SQLException {
		OrderService showService = new OrderService();
		ApiResponse response = showService.orderShow(order);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns customer details whose orderNumber matches with the one
	 * present in the database
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Order order) throws SQLException {
		OrderService showService = new OrderService();
		ApiResponse response = showService.orderById(order);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method insert a new order in the database
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Order order) throws SQLException {
		OrderService showService = new OrderService();
		ApiResponse response = showService.saveOrder(order);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method updates the data for a orderNumber
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Order order) throws SQLException {
		OrderService showService = new OrderService();
		ApiResponse response = showService.updateOrder(order);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method logically delete's an entry from the order database matching with
	 * the orderNumber
	 * 
	 * @param order
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(Order order) throws SQLException {
		OrderService showService = new OrderService();
		ApiResponse response = showService.deleteOrder(order);
		return Response.status(200).entity(response).build();

	}
}
