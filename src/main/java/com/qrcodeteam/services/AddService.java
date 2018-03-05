package com.qrcodeteam.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

import com.qrcodeteam.beans.Login;

@Component
@Path("/add")
public class AddService {
	
	@GET
	@Path("/addx")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON})
    public Login add(@QueryParam("arg01") Integer arg01, @QueryParam("arg02") Integer arg02) {
        return new Login("Jonas","Hounsou");
    }
}
