package com.splus.learn.rest.resource;

import java.io.IOException;
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
 * 
 * @author Nazish.Khatoon
 *
 */
public class ProductResource {
	/**
	 * This method returns the Api Response for all the products in the database.
	 * 
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
	 * This method returns the Api Response for the product where passed productCode
	 * matches with the product_code in the database.
	 * 
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

	/**
	 * This method returns the Api response for the inserted product.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */

	@POST
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Product product) throws SQLException {
		ProductService productService = new ProductService();
		ApiResponse response = productService.save(product);
		return Response.status(200).entity(response).build();
	}

	/**
	 * This method returns the Api response for the product where passed productCode
	 * matches with the product_code and record_status is greater than 0.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(Product product) throws SQLException {
		ProductService productService = new ProductService();
		ApiResponse response = productService.delete(product);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for the updated product where passed
	 * productCode matches with the product_code in the table and record_status is
	 * greater than 0.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Product product) throws SQLException {
		ProductService productService = new ProductService();
		ApiResponse response = productService.update(product);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for exporting the mysql database into
	 * excel sheet
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/exporttoexcel")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response export(Product product) throws SQLException, IOException {
		ProductService productService = new ProductService();
		ApiResponse response = productService.export(product);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api response for importing the data from excel into mysql database.
	 * 
	 * @param product
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/load")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response load(Product product) throws SQLException, IOException {
		ProductService productService = new ProductService();
		ApiResponse response = productService.load(product);
		return Response.status(200).entity(response).build();

	}
}