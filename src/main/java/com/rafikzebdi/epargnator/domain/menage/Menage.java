package com.rafikzebdi.epargnator.domain.menage;

import com.rafikzebdi.epargnator.domain.personne.Personne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    public Menage() {
        super();
    }

    public Menage(String name, Date dateCreation, Date dateMiseAJour, Personne p1) {
        super();
        this.name = name;
        this.dateCreation = dateCreation;
        this.dateMiseAJour = dateMiseAJour;
        this.p1 = p1;
        this.p2 = null;
    }

    public Menage(String name, Date dateCreation, Date dateMiseAJour, Personne p1,
                  Personne p2) {
        super();
        this.name = name;
        this.dateCreation = dateCreation;
        this.dateMiseAJour = dateMiseAJour;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Menage menage = (Menage) o;

        return new EqualsBuilder ()
                .append ( name, menage.name )
                .append ( dateCreation, menage.dateCreation )
                .append ( dateMiseAJour, menage.dateMiseAJour )
                .append ( p1, menage.p1 )
                .append ( p2, menage.p2 )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( dateCreation )
                .append ( dateMiseAJour )
                .append ( p1 )
                .append ( p2 )
                .toHashCode ();
    }

    @Override public String toString() {
        return "Menage{" +
                "name='" + name + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateMiseAJour=" + dateMiseAJour +
                ", p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

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
