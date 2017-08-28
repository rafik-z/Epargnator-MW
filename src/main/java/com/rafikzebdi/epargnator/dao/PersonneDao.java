package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.personne.Personne;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonneDao {

    @PersistenceContext
    private EntityManager em;

    public List<Personne> getAllPersonne(){
        final String jpqlQuery = "SELECT p FROM Personne p";
        final TypedQuery<Personne> query = em.createQuery ( jpqlQuery, Personne.class );
        final List<Personne> personnes = query.getResultList ();
        return personnes;
    }

    public List<Personne> getSpecificPersonne(final String reference){
        final String jpqlQuery = "SELECT p FROM Personne p WHERE p.name LIKE :ref";
        final TypedQuery<Personne> query = em.createQuery ( jpqlQuery, Personne.class );
        query.setParameter ( "ref", reference );
        final List<Personne> personnes = query.getResultList ();
        return personnes;

    }

    public void addPersonne(final Personne personne){
        em.persist ( personne );
    }

    public void updatePersonne(final Personne personne){
        em.merge ( personne );
    }

    public void deletePersonne(final String idToDelete){
        final Personne personneToDelete = em.find ( Personne.class, idToDelete );
        em.remove ( personneToDelete );
    }
}
