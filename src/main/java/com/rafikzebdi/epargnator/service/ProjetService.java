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

    public Projet addProjet(final Projet projetToAdd){
        final Projet addedProjet = projetDao.addProjet ( projetToAdd );
        return addedProjet;
    }

    public List<Projet> getAllProjets() {
        return projetDao.getAllProjects ();
    }
}
