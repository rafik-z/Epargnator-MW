package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.charge.Charge;
import com.rafikzebdi.epargnator.domain.personne.Personne;
import com.rafikzebdi.epargnator.service.ChargeService;
import com.rafikzebdi.epargnator.service.PersonneService;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Transactional
@WebService
@Path ( "/personne" )
public class PersonneRS {

    @EJB
    private PersonneService personneService;

    @EJB
    private ChargeService chargeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonne(){
        Response.ResponseBuilder builder = null;

        try {
            final List<Personne> personnesFound = personneService.getAllPersonne ();
            builder = Response.ok (personnesFound);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    @GET
    @Path ( "/{reference}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificPersonne(@PathParam ( "reference" )final int referenceToFind){
        Response.ResponseBuilder builder = null;

        try {
            final List<Personne> personnesSpecificFound = personneService.getSpecificPersonne ( referenceToFind );
            builder = Response.ok (personnesSpecificFound);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPersonne(final Personne personneToAdd){
        Response.ResponseBuilder builder = null;

        try {
            formPersonne ( personneToAdd );
            final Personne per = personneService.addPersonne ( personneToAdd );
            builder = Response.ok (per);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifyPersonne(final Personne personneToModify){
        Response.ResponseBuilder builder = null;

        try {
            personneToModify.setDateMiseAJour ( Date.from ( Instant.now ()) );
            personneService.modifyPersonne ( personneToModify );
            builder = Response.ok (personneToModify);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }


    @DELETE
    @Path ( "/{reference}" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonne(@PathParam ( "reference" ) final int referenceToDelete){
        Response.ResponseBuilder builder = null;

        try {
            personneService.deletePersonne ( referenceToDelete );
            builder = Response.ok ( referenceToDelete);
        } catch (Exception e) {
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    private void formPersonne(final Personne personneToForm){
        final int loop = personneToForm.getChargesPersonne ().size ();
        final List<Charge> charges = personneToForm.getChargesPersonne ();

        if (loop > 0) {
            for (Charge charge:charges) {
                chargeService.addCharge ( charge );
            }
        }

    }
}
