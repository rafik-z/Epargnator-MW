package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.charge.ChargeInvalidException;
import com.rafikzebdi.epargnator.domain.menage.Menage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MenageDao {

    @PersistenceContext
    private EntityManager em;

    public List<Menage> getAllMenage(){
        final String jpqlQuery = "SELECT m FROM Menage m";
        final TypedQuery<Menage> query = em.createQuery(jpqlQuery, Menage.class);
        final List<Menage> foundMenages = query.getResultList();
        return foundMenages;
    }

    public List<Menage> getSpecificMenage(final String menageToFind){
        List<Menage> foundMenages = new ArrayList <Menage> (  );

        return foundMenages;
    }

    public void addMenage (final Menage menageToAdd){

        em.persist ( menageToAdd );
    }

    public void updateMenage(final Menage menageToUpdate){
        em.merge ( menageToUpdate );
    }

    public void deleteMenage(final String idToDelete) throws ChargeInvalidException {
        final Menage foundMenage = em.find ( Menage.class, idToDelete );
        if(foundMenage==null){
            throw new ChargeInvalidException("Charge NULL");
        }
        em.remove ( foundMenage);
    }




}
