package com.rafikzebdi.epargnator.dao;

import com.rafikzebdi.epargnator.domain.charge.Charge;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ChargeDao{

    @PersistenceContext
    private EntityManager em;

    public void addCharge(Charge chargeToAdd) {
        em.persist ( chargeToAdd );
    }

    public void modifyCharge(Charge charge) {
        em.merge ( charge );
    }
}
