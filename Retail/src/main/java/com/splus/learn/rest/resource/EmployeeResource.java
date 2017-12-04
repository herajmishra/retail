package com.splus.learn.rest.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.splus.learn.rest.beans.ApiResponse;
import com.splus.learn.rest.beans.Employee;
import com.splus.learn.rest.service.EmployeeService;

@Path("/employee")
public class EmployeeResource {
	@POST
	@Path("/findall")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getEmployee(Employee employee) throws SQLException {
		EmployeeService showService = new EmployeeService();
		ApiResponse response = showService.employeeShow(employee);
		return Response.status(200).entity(response).build();

	}
	
	@POST
	@Path("/findid")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(Employee employee) throws SQLException {
		EmployeeService showService = new EmployeeService();
		ApiResponse response = showService.employeeById(employee);
		return Response.status(200).entity(response).build();

	}
}
