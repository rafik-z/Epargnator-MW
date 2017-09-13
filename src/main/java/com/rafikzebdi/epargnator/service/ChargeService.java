package com.rafikzebdi.epargnator.service;

import com.rafikzebdi.epargnator.dao.ChargeDao;
import com.rafikzebdi.epargnator.domain.charge.Charge;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class ChargeService {

    @EJB
    private ChargeDao chargeDao;

    public void addCharge(final Charge chargeToAdd){
        chargeDao.addCharge(chargeToAdd);
    }


    public void modifyCharge(final Charge charge) {
        chargeDao.modifyCharge(charge);
    }
}
