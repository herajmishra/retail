package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Payment;
import com.splus.learn.rest.service.PaymentService;

@Path("/payment")
/**
 * This class is for Payment Resource
 * 
 * @author Nazish.Khatoon
 *
 */

public class PaymentResource {
	/**
	 * This method returns the Api Response for the payment where passed paymnetId
	 * matches with the payment_id in the database.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Payment payment) throws SQLException {
		PaymentService showService = new PaymentService();
		ApiResponse response = showService.paymentId(payment);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api Response for the payment where passed
	 * PaymentRefNo matches with the payment_refno in the database.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findrefno")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByRefNo(Payment payment) throws SQLException {
		PaymentService showService = new PaymentService();
		ApiResponse response = showService.paymentRefNo(payment);
		return Response.status(200).entity(response).build();

	}

	/**
	 * This method returns the Api Response for the payment where passed
	 * customerNumber matches with the customer_number in the database.
	 * 
	 * @param payment
	 * @return response
	 * @throws SQLException
	 */
	@POST
	@Path("/findcustomerno")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByCustomerNumber(Payment payment) throws SQLException {
		PaymentService showService = new PaymentService();
		ApiResponse response = showService.paymentCustomerNumber(payment);
		return Response.status(200).entity(response).build();

	}

}
