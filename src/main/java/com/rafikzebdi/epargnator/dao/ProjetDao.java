package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.projet.Projet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProjetDao {

    @PersistenceContext
    private EntityManager em;

    public List<Projet> getAllProjects(){
        final String jpqlQuery = "SELECT p FROM Projet p";
        final TypedQuery<Projet> query = em.createQuery ( jpqlQuery, Projet.class );
        final List<Projet> projetsFound = query.getResultList ();
        return projetsFound;
    }
}
