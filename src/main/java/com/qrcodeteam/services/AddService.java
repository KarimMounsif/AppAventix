package com.qrcodeteam.services;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

import com.qrcodeteam.beans.Login;
import com.qrcodeteam.utilitaire.JsonResponse;

@Component
@Path("/add")
public class AddService {
	
	@GET
	@Path("/addx")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON})
    public JsonResponse add(@QueryParam("arg01") String arg01, @QueryParam("arg02") String arg02) {
		Map<String, String> h=new  HashMap<String, String>();
		h.put("key",arg01+arg02);
		return new JsonResponse(true, null, h);
        //return new Login("Jonas","Hounsou");
    }
}
