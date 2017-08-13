package com.rafikzebdi.epargnator.domain.projet;

import com.rafikzebdi.epargnator.domain.composant.Composant;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "T_PROJET")
@XmlRootElement
public class Projet {
    private String name;
    private ArrayList<Composant> composants;
    private Date dateLimite;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList <Composant> getComposants() {
        return composants;
    }

    public void setComposants(ArrayList <Composant> composants) {
        this.composants = composants;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
}
