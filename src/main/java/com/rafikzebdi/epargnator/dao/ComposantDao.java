package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.composant.ComposantInvalidException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

@Stateless
public class ComposantDao {

    @PersistenceContext
    private EntityManager em;

    public Composant getComposant(final int composantToGet) throws ComposantInvalidException {
        final Composant foundComposant = em.find ( Composant.class, composantToGet );
        if (foundComposant == null){
            throw new ComposantInvalidException ( "Composant NULL" );
        }

        return foundComposant;
    }

    public void addComposant(final Composant composantToAdd){
        em.persist ( composantToAdd );
    }

    public void deleteComposant(final String composantToDelete) throws ComposantInvalidException {
        final Composant foundComposant = em.find ( Composant.class, composantToDelete );
        if(foundComposant == null){
            throw new ComposantInvalidException ( "Composant NULL" );
        } else{
            em.remove ( foundComposant );
        }
    }
}
