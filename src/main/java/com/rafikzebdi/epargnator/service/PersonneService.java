package com.rafikzebdi.epargnator.service;

import com.rafikzebdi.epargnator.dao.PersonneDao;
import com.rafikzebdi.epargnator.domain.personne.Personne;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class PersonneService {

    @EJB
    private PersonneDao personneDao;

    public List<Personne> getAllPersonne(){

        return personneDao.getAllPersonne ();

    }
    public List<Personne> getSpecificPersonne(final String personneToFind){

        return personneDao.getSpecificPersonne ( personneToFind );
    }

    public void addPersonne(final Personne personneToAdd){
        personneDao.addPersonne ( personneToAdd );
    }

    public void modifyPersonne(final Personne personneToModify){
        personneDao.updatePersonne ( personneToModify );
    }

    public void deletePersonne(final String reference){
        personneDao.deletePersonne ( reference );
    }
}
