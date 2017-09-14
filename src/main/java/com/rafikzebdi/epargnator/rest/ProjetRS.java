package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.ProjetTO;
import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.projet.Projet;
import com.rafikzebdi.epargnator.service.ComposantService;
import com.rafikzebdi.epargnator.service.ProjetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Transactional
@WebService
@Path ( "/projet" )
public class ProjetRS {

    static final Logger LOG = LoggerFactory.getLogger ( ProjetRS.class );

    private Projet projetToSend = null;

    @EJB
    private ProjetService projetService;

    @EJB
    private ComposantService composantService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjets(){
        Response.ResponseBuilder builder = null;
        LOG.info ( "Requête GET reçue." );

        try {
            final List<Projet> projets = projetService.getAllProjets();
            builder = Response.ok (projets);
            LOG.info ( "Requête GET executée avec succés." );
        } catch (Exception e) {
            builder = Response.status ( Response.Status.BAD_REQUEST );
            LOG.error ( "Requête GET : BAD REQUEST" );
        }

        return builder.build ();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProjet(final Projet inputProjet){
        Response.ResponseBuilder builder = null;

        try {
            formProjet (inputProjet);
            projetService.addProjet ( inputProjet );
            builder = Response.ok ( inputProjet );
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProjet(@PathParam("id")final String reference, final Projet inputProjet){
        Response.ResponseBuilder builder = null;

        try {
            formProjet ( inputProjet);
            projetService.updateProjet(inputProjet);
            builder = Response.ok(inputProjet);
        } catch (Exception e) {
            e.printStackTrace();
            builder = Response.status(Response.Status.BAD_REQUEST);
        }

        return builder.build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProjet(@PathParam("id") final String idToDelete){
        Response.ResponseBuilder builder = null;


        try {
            projetService.deleteProjet(idToDelete);
            builder = Response.ok ();
        } catch (Exception e) {
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build();
    }

    private void formProjet(final Projet projetToForm){
        final List<Composant> composants= projetToForm.getComposantsProjet ();
        for (Composant composant:composants) {
            composantService.addComposant ( composant);
        }

    }


}
