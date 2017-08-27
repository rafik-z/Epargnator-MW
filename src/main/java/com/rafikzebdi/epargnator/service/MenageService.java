package com.rafikzebdi.epargnator.service;

import com.rafikzebdi.epargnator.dao.MenageDao;
import com.rafikzebdi.epargnator.domain.charge.ChargeInvalidException;
import com.rafikzebdi.epargnator.domain.menage.Menage;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@Transactional
public class MenageService {

    @EJB
    private MenageDao menageDao;

    public List<Menage> getAllMenage(){
        return menageDao.getAllMenage ();
    }

    public List<Menage> getSpecificMenage(final String menageToFind){
        return menageDao.getSpecificMenage ( menageToFind );
    }

    public void addMenage(final Menage menageToAdd){
        menageDao.addMenage ( menageToAdd );

    }
    public void modifyMenage(final Menage menageToModify){
        menageDao.modifyMenage ( menageToModify );

    }
    public void deleteMenage(final String menageToDelete) throws ChargeInvalidException {
        menageDao.deleteMenage ( menageToDelete );

    }
}
