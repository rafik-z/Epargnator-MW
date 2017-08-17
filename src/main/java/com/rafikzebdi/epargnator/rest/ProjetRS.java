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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@WebService
@Path ( "/projet" )
public class ProjetRS {

    private List<Composant> listComposants = new ArrayList<Composant>();

    @EJB
    private ProjetService projetService;
    @EJB
    private ComposantService composantService;

    @GET
    @Path ( "/auto" )
    @Produces
    public Response autoAdd(){
        Response.ResponseBuilder builder = null;
        Projet projet = null;
        try {
            List<Composant> listComposants = new ArrayList <Composant> (  );

            Composant comp1 = new Composant ( "vol", 1200 ,1 );
            Composant comp2 = new Composant ( "nourriture", 2400 ,2 );
            Composant comp3 = new Composant ( "autres", 3600 ,3);
            listComposants.add ( comp1 );
            listComposants.add ( comp2 );
            listComposants.add ( comp3 );
            Date date = new SimpleDateFormat ( "yyyy-MM-dd" ).parse ( "2018-08-08" );
            projet = new Projet ( "Bali", listComposants, date);
            projetService.addProjet ( projet );

            builder = Response.ok (projet);
        } catch (ParseException e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.EXPECTATION_FAILED );
        }


        return builder.build ();
    }
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
            builder = Response.ok (projetToAdd.getComposants ());
        } catch (Exception e) {
            e.printStackTrace ();
            builder = Response.status ( Response.Status.BAD_REQUEST );
        }

        return builder.build ();
    }

    private Projet formProjet(final ProjetTO projetToModify) throws Exception {
        final int loop = projetToModify.getNbrComposants ();
        System.out.println ("AJOUT\n\nLOOP = "+loop+"\n\nAJOUT");

        listComposants.clear ();
        final String name = projetToModify.getName ();
        final Date dateLimite = projetToModify.getDateLimite ();
        switch (loop){
            case 1: formComposant1 (projetToModify);
                break;
            case 2: formComposant2 (projetToModify);
                break;
            case 3: formComposant3 (projetToModify);
                break;
            case 4: formComposant4 (projetToModify);
                break;
            case 5: formComposant5 (projetToModify);
                break;
            default:
                break;
        }
        if (listComposants.size ()<1){
            System.out.println ("ERREUR\nERREUR\nERREUR\n");
        }
        System.out.println (listComposants.get ( 1 ).toString ());

        Projet projetToSend = new Projet (name, listComposants, dateLimite );
        return projetToSend;
    }


    private void formComposant1(final ProjetTO projet){
        listComposants.add ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_1 () );
        System.out.println ("AJOUT\n\nformComposant1\n\nAJOUT");
    }

    private void formComposant2(final ProjetTO projet){
        listComposants.add ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_1 () );
        listComposants.add ( projet.getComposant_2 () );
        composantService.addComposant ( projet.getComposant_2 () );
        System.out.println ("AJOUT\n\nformComposant2\n\nAJOUT");
    }

    private void formComposant3(final ProjetTO projet){
        listComposants.add ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_1 () );
        listComposants.add ( projet.getComposant_2 () );
        composantService.addComposant ( projet.getComposant_2 () );
        listComposants.add ( projet.getComposant_3 () );
        composantService.addComposant ( projet.getComposant_3 () );
        System.out.println ("AJOUT\n\nformComposant3\n\nAJOUT");
    }

    private void formComposant4(final ProjetTO projet){
        listComposants.add ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_1 () );
        listComposants.add ( projet.getComposant_2 () );
        composantService.addComposant ( projet.getComposant_2 () );
        listComposants.add ( projet.getComposant_3 () );
        composantService.addComposant ( projet.getComposant_3 () );
        listComposants.add ( projet.getComposant_4 () );
        composantService.addComposant ( projet.getComposant_4 () );
        System.out.println ("AJOUT\n\nformComposant4\n\nAJOUT");
    }

    private void formComposant5(final ProjetTO projet){
        listComposants.add ( projet.getComposant_1 () );
        composantService.addComposant ( projet.getComposant_1 () );
        listComposants.add ( projet.getComposant_2 () );
        composantService.addComposant ( projet.getComposant_2 () );
        listComposants.add ( projet.getComposant_3 () );
        composantService.addComposant ( projet.getComposant_3 () );
        listComposants.add ( projet.getComposant_4 () );
        composantService.addComposant ( projet.getComposant_4 () );
        listComposants.add ( projet.getComposant_5 () );
        composantService.addComposant ( projet.getComposant_5 () );
        System.out.println ("AJOUT\n\nformComposant5\n\nAJOUT");
    }


}
