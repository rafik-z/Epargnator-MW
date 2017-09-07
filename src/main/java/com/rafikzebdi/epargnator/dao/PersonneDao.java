package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.personne.Personne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class PersonneDao {

    private final static Logger LOG = LoggerFactory.getLogger ( Personne.class );

    @PersistenceContext
    private EntityManager em;

    public List<Personne> getAllPersonne(){
        final String jpqlQuery = "SELECT r FROM Personne r";
        final TypedQuery<Personne> query = em.createQuery ( jpqlQuery, Personne.class );
        final List<Personne> personnes = query.getResultList ();
        LOG.info ( "LOG // Nbr d'entrée dans la liste : " + personnes.size () );
        return personnes;
    }

    public List<Personne> getSpecificPersonne(final String reference){
        final String jpqlQuery = "SELECT r FROM Personne r WHERE r.name LIKE :ref";
        final TypedQuery<Personne> query = em.createQuery ( jpqlQuery, Personne.class );
        query.setParameter ( "ref", reference );
        final List<Personne> personnes = query.getResultList ();
        return personnes;

    }

    public Personne addPersonne(final Personne personne){
        em.persist ( personne );
        return personne;
    }

    public void updatePersonne(final Personne personne){
        em.merge ( personne );
    }

    public void deletePersonne(final String idToDelete){
        final Personne personneToDelete = em.find ( Personne.class, idToDelete );
        em.remove ( personneToDelete );
    }
}
