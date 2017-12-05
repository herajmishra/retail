package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Product;
import com.splus.learn.rest.service.ProductService;

@Path("/product")
/**
 * This is the class for Product Resource
 * @author Nazish.Khatoon
 *
 */
public class ProductResource {
	/**
	 * This method returns the Api Response for all the products in the database.
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProduct(Product product) throws SQLException {
		ProductService showService = new ProductService();
		ApiResponse response = showService.productShow(product);
		return Response.status(200).entity(response).build();

	}
/**
 * This method returns the Api Response for the product where passed Product code matches the Product code in the database.
 * @param product
 * @return response
 * @throws SQLException
 */
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Product product) throws SQLException {
		ProductService showService = new ProductService();
		ApiResponse response = showService.productByCode(product);
		return Response.status(200).entity(response).build();

	}

}
