package com.rafikzebdi.epargnator.service;

import com.rafikzebdi.epargnator.dao.ComposantDao;
import com.rafikzebdi.epargnator.domain.composant.Composant;
import com.rafikzebdi.epargnator.domain.composant.ComposantInvalidException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

@Stateless
public class ComposantService {

    @EJB
    private ComposantDao composantDao;

    public Composant getComposant(final String composantToGet) throws ComposantInvalidException {
        try {
            return composantDao.getComposant ( composantToGet );
        } catch (ComposantInvalidException e) {
            throw e;
        }
    }
}
