package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.ProjetTO;
import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.projet.Projet;
import com.rafikzebdi.epargnator.service.ComposantService;
import com.rafikzebdi.epargnator.service.ProjetService;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Status;
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

    private Projet projetToSend = null;

    @EJB
    private ProjetService projetService;
    @EJB
    private ComposantService composantService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjets(){
        Response.ResponseBuilder builder = null;

        try {
            final List<Projet> projets = projetService.getAllProjets();
            builder = Response.ok (projets);
        } catch (Exception e) {
            builder = Response.status ( Status.STATUS_NO_TRANSACTION );
        }

        return builder.build ();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProjet(final ProjetTO inputProjet){
        Response.ResponseBuilder builder = null;

        try {
            final Projet projetToAdd = formProjet (inputProjet);
            projetService.addProjet ( projetToAdd );
            builder = Response.ok (projetToAdd);
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProjet(@PathParam("id")final String reference, final ProjetTO inputProjet){
        Response.ResponseBuilder builder = null;

        try {
            final Projet projetToUpdate = formProjet(inputProjet);
            projetService.updateProjet(projetToUpdate);
            builder = Response.ok(projetToUpdate);
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

        projetService.deleteProjet(idToDelete);

        return builder.build();
    }

    private Projet formProjet(final ProjetTO projetToModify) throws Exception {
        final int loop = projetToModify.getNbrComposants ();
        final String name = projetToModify.getName ();
        final Date dateLimite = projetToModify.getDateLimite ();
        switch (loop){
            case 1: formComposant1 (projetToModify);
                projetToSend = new Projet (name, projetToModify.getComposant_1 (), dateLimite );
                break;
            case 2: formComposant2 (projetToModify);
                projetToSend = new Projet (name, projetToModify.getComposant_1 (), projetToModify.getComposant_2 (),
                        dateLimite );
                break;
            case 3: formComposant3 (projetToModify);
                projetToSend = new Projet (name, projetToModify.getComposant_1 (), projetToModify.getComposant_2 (),
                        projetToModify.getComposant_3 (), dateLimite );
                break;
            case 4: formComposant4 (projetToModify);
                projetToSend = new Projet (name, projetToModify.getComposant_1 (), projetToModify.getComposant_2 (),
                        projetToModify.getComposant_3 (),projetToModify.getComposant_4 (), dateLimite );
                break;
            case 5: formComposant5 (projetToModify);
                projetToSend = new Projet (name, projetToModify.getComposant_1 (), projetToModify.getComposant_2 (),
                        projetToModify.getComposant_3 (), projetToModify.getComposant_4 (),projetToModify
                        .getComposant_5 (), dateLimite );
                break;
            default:
                break;
        }
        return projetToSend;
    }


    private void formComposant1(final ProjetTO projet){
        composantService.addComposant ( projet.getComposant_1 () );
    }

    private void formComposant2(final ProjetTO projet){
        composantService.addComposant ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_2 () );
    }

    private void formComposant3(final ProjetTO projet){
        formComposant2 ( projet );
        composantService.addComposant ( projet.getComposant_3 () );
    }

    private void formComposant4(final ProjetTO projet){
        formComposant3 ( projet );
        composantService.addComposant ( projet.getComposant_4 () );
    }

    private void formComposant5(final ProjetTO projet){
        formComposant4 ( projet );
        composantService.addComposant ( projet.getComposant_5 () );
    }


}
