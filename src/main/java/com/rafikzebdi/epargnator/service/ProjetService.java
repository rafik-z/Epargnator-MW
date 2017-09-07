package com.rafikzebdi.epargnator.service;

import com.rafikzebdi.epargnator.dao.ProjetDao;
import com.rafikzebdi.epargnator.domain.projet.Projet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class ProjetService {

    @EJB
    private ProjetDao projetDao;

    public void autoAdd(final Projet projet){
        projetDao.autoAdd ( projet );
    }

    public Projet addProjet(final Projet projetToAdd){
        return projetDao.addProjet ( projetToAdd );
    }

    public List<Projet> getAllProjets() {
        return projetDao.getAllProjects ();
    }

    public void updateProjet(final Projet projetToUpdate){
        projetDao.updateProjet(projetToUpdate);
    }

    public void deleteProjet(final String idToDelete) {
        projetDao.deleteProjet(idToDelete);
    }
}
