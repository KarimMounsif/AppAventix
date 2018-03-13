package com.qrcodeteam.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.qrcodeteam.beans.Login;

@Component
@Path("/add")
public class AddService {
	
	@POST
	@Path("/addx")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON})
    public Login add(@QueryParam("arg01") String arg01/*, @QueryParam("arg02") String arg02*/) {
		System.out.println(arg01 /*+ arg02*/);
        return new Login("Jonas","Hounsou");
    }
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	public String update(Login login) {
		Login log = new Login();
		log.setLogin(login.getLogin());
		log.setMdp(login.getMdp());
		return "mise a jour mot de passe de" + login.getLogin() +   " avec Succes";
	}
}
 

	