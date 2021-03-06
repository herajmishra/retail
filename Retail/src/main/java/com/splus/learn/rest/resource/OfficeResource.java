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

	/**
	 * This method inserts a new office record in the database
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Office office) throws SQLException {
		OfficeService showService = new OfficeService();
		ApiResponse response = showService.saveOffice(office);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method updates the data for a particular officeCode in office database
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Office office) throws SQLException {
		OfficeService showService = new OfficeService();
		ApiResponse response = showService.updateOffice(office);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method logically delete's an entry from the office database matching
	 * with the officeCode
	 * 
	 * @param office
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(Office office) throws SQLException {
		OfficeService showService = new OfficeService();
		ApiResponse response = showService.deleteOffice(office);
		return Response.status(200).entity(response).build();

	}
}
