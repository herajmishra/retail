package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;

import com.splus.learn.rest.beans.ProductLine;
import com.splus.learn.rest.service.ProductLineService;


@Path("/productline")
/**
 * This is the class for ProductLine Resource
 * 
 * @author Nazish.Khatoon
 *
 */
public class ProductLineResource {
	/**
	 * This method returns the Api Response for all the ProductLines in the
	 * database.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getCustomer(ProductLine productLine) throws SQLException {
		ProductLineService showService = new ProductLineService();
		ApiResponse response = showService.productLineShow(productLine);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api Response for the productLine where passed
	 * productLine matches with the Product_line in the database.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(ProductLine productLine) throws SQLException {
		ProductLineService showService = new ProductLineService();
		ApiResponse response = showService.productLineById(productLine);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for the inserted product line.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(ProductLine productLine) throws SQLException {
		ProductLineService productLineService = new ProductLineService();
		ApiResponse response = productLineService.save(productLine);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for the product line where passed
	 * productLine matches with the product_line and record_status is greater than
	 * 0.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(ProductLine productLine) throws SQLException {
		ProductLineService productLineService = new ProductLineService();
		ApiResponse response = productLineService.delete(productLine);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for the updated productLine where passed
	 * productLine matches with the product_line in the table and record_status is greater than 0.
	 * 
	 * @param productLine
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(ProductLine productLine) throws SQLException {
		ProductLineService productLineService = new ProductLineService();
		ApiResponse response = productLineService.update(productLine);
		return Response.status(200).entity(response).build();

	}

}