package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.personne.Personne;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PersonneDao {

    @PersistenceContext
    private EntityManager em;

    public List<Personne> getAllPersonne(){
        List<Personne> personnes = new ArrayList <Personne> (  );

        return personnes;
    }

    public List<Personne> getSpecificPersonne(){
        List<Personne> personnes = new ArrayList <Personne> (  );

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
