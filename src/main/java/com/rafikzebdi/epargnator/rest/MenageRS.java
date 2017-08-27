package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.charge.ChargeInvalidException;
import com.rafikzebdi.epargnator.domain.menage.Menage;
import com.rafikzebdi.epargnator.service.MenageService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Transactional
@Path ( "/menage" )
@WebService
public class MenageRS {

    @EJB
    private MenageService menageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMenage(){
        Response.ResponseBuilder builder = null;

        try {
            final List<Menage> foundMenages = menageService.getAllMenage ();
            builder = Response.ok (foundMenages);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }
        return builder.build ();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificMenage(@PathParam ( "id" )final String reference){
        Response.ResponseBuilder builder = null;

        try {
            final List<Menage> foundMenages = menageService.getSpecificMenage (reference);
            builder = Response.ok (foundMenages);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }
        return builder.build ();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMenage(final Menage menageToAdd){
        Response.ResponseBuilder builder = null;

        try {
            menageService.addMenage ( menageToAdd );
            builder = Response.ok (menageToAdd);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyMenage(final Menage menageToModify){
        Response.ResponseBuilder builder = null;

        try {
            menageService.modifyMenage ( menageToModify );
            builder = Response.ok (menageToModify);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    @DELETE
    @Path ( "/{id}" )
    public Response deleteMenage(@PathParam ( "id" )final String reference){
        Response.ResponseBuilder builder = null;

        try {
            menageService.deleteMenage ( reference );
            builder = Response.ok (reference);
        } catch (ChargeInvalidException e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return  builder.build ();
    }
}
