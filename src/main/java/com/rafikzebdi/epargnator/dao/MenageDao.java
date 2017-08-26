package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.menage.Menage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class MenageDao {

    @PersistenceContext
    private EntityManager em;

    public List<Menage> getAllMenage(){
        List<Menage> menages = new ArrayList <Menage> (  );

        return menages;
    }

    public List<Menage> getSpecificMenage(final String menageToFind){
        List<Menage> menages = new ArrayList <Menage> (  );

        return menages;
    }

    public void addMenage (final Menage menageToAdd){
        em.persist ( menageToAdd );
    }

    public void updateMenage(final Menage menageToUpdate){
        em.merge ( menageToUpdate );
    }

    public void deleteMenage(final String idToDelete){
        final Menage menage = em.find ( Menage.class, idToDelete );
        em.remove ( menage );
    }




}
