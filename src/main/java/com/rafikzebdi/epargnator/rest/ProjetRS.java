package com.rafikzebdi.epargnator.rest;

import com.rafikzebdi.epargnator.domain.ProjetTO;
import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.projet.Projet;
import com.rafikzebdi.epargnator.service.ProjetService;
import jdk.net.SocketFlow;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.transaction.Status;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@WebService
@Path ( "/projet" )
public class ProjetRS {

    @EJB
    private ProjetService projetService;

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

    private Projet formProjet(final ProjetTO projetToModify){
        final String name = projetToModify.getName ();
        final Date dateLimite = projetToModify.getDateLimite ();
        List<Composant> listComposants = new ArrayList<Composant>();
        Composant comp1 = new Composant (  );
        comp1.setName ( projetToModify.getComposant_1 ().getName () );
        comp1.setImportance ( projetToModify.getComposant_1 ().getImportance () );
        comp1.setMontant ( projetToModify.getComposant_1 ().getMontant () );
        listComposants.add ( comp1 );



        Projet projetToSend = new Projet (name, listComposants, dateLimite );
        return projetToSend;
    }

    private Composant formComposant(final Composant composant){
        return null;
    }


}
