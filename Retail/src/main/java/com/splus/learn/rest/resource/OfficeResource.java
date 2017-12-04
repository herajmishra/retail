package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Office;
import com.splus.learn.rest.service.OfficeService;

/**
 * This is resource class for Office
 * 
 * @author Rishabh Goel
 *
 */
@Path("/office")
public class OfficeResource {
	/**
	 * This method returns all the offices present in the database
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getOffice(Office office) throws SQLException {
		OfficeService showService = new OfficeService();
		ApiResponse response = showService.officeShow(office);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns office details whose officeCode matches with the one
	 * present in the database
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Office office) throws SQLException {
		OfficeService showService = new OfficeService();
		ApiResponse response = showService.officeByCode(office);
		return Response.status(200).entity(response).build();

	}
}
