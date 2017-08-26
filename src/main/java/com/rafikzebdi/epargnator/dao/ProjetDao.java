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

    public void autoAdd(final Projet projet){
        em.persist ( projet );
    }

    public Projet getProject(final String reference){
        return em.find ( Projet.class, reference );
    }

    public Projet addProjet (final Projet projetToAdd){
        em.persist ( projetToAdd );
        return projetToAdd;
    }

    public void updateProjet(final Projet projetToUpdate){
        em.merge(projetToUpdate);
    }

    public void deleteProjet(final String idToDelete) {
        final Projet projetToDelete = em.find(Projet.class, idToDelete);
        em.remove(projetToDelete);
    }
}
