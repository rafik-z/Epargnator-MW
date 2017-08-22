package com.rafikzebdi.epargnator.domain.menage;

import com.rafikzebdi.epargnator.domain.personne.Personne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="T_MENAGE")
@XmlRootElement
public class Menage implements Serializable{

    private String name;
    private Date dateCreation;
    private Date dateMiseAJour;
    private Personne p1;
    private Personne p2;

    @Id
    @Column(name = "MEN_NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="MEN_DATE_CREA")
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = "MEN_DATE_MAJ")
    public Date getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(Date dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    @Column(name = "MEN_P1", nullable = false)
    public Personne getP1() {
        return p1;
    }

    public void setP1(Personne p1) {
        this.p1 = p1;
    }

    @Column(name = "MEN_P2", nullable = true)
    public Personne getP2() {
        return p2;
    }

    public void setP2(Personne p2) {
        this.p2 = p2;
    }
}
