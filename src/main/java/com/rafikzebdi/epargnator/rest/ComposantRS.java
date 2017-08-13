package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.composant.ComposantInvalidException;
import com.rafikzebdi.epargnator.service.ComposantService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Transactional
@WebService
@Path ( "/projet" )
public class ComposantRS {

    @EJB
    private ComposantService composantService;

    @GET
    @Path ( "{composant}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComposant(@PathParam ( "composant" )final String composantReference){
        Response.ResponseBuilder builder = null;

        try {
            final Composant composant = composantService.getComposant ( composantReference );
            builder = Response.ok (composant);
        } catch (ComposantInvalidException e) {
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();

    }

}
