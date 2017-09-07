package com.rafikzebdi.epargnator.domain.menage;

import com.rafikzebdi.epargnator.domain.charge.Charge;
import com.rafikzebdi.epargnator.domain.personne.Personne;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="T_MENAGE")
@XmlRootElement
public class Menage implements Serializable{

    private String name;
    private Date dateCreation;
    private Date dateMiseAJour;
    private Personne p1;
    private Personne p2;
    private List<Charge> charges;

    public Menage() {
        super();
    }

    public Menage(final String name, final Date dateCreation, final Date dateMiseAJour, final Personne p1,
                  final List<Charge> charges) {
        super();
        this.name = name;
        this.dateCreation = dateCreation;
        this.dateMiseAJour = dateMiseAJour;
        this.p1 = p1;
        this.p2 = null;
        this.charges = charges;
    }

    public Menage(final String name, final Date dateCreation, final Date dateMiseAJour, final Personne p1,
                  final Personne p2, final List<Charge> charges) {
        super();
        this.name = name;
        this.dateCreation = dateCreation;
        this.dateMiseAJour = dateMiseAJour;
        this.p1 = p1;
        this.p2 = p2;
        this.charges = charges;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Menage menage = (Menage) o;

        return new EqualsBuilder ()
                .append ( this.name, menage.name )
                .append ( this.dateCreation, menage.dateCreation )
                .append ( this.dateMiseAJour, menage.dateMiseAJour )
                .append ( this.p1, menage.p1 )
                .append ( this.p2, menage.p2 )
                .append ( this.charges, menage.charges )
                .build ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.name )
                .append ( this.dateCreation )
                .append ( this.dateMiseAJour )
                .append ( this.p1 )
                .append ( this.p2 )
                .append ( this.charges )
                .toHashCode ();
    }

    @Override public String toString() {
        return "Menage{" +
                "name='" + this.name + '\'' +
                ", dateCreation=" + this.dateCreation +
                ", dateMiseAJour=" + this.dateMiseAJour +
                ", p1=" + this.p1 +
                ", p2=" + this.p2 +
                ", charges=" + this.charges+
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

    @ElementCollection
    public List <Charge> getCharges() {
        return charges;
    }

    public void setCharges(List <Charge> charges) {
        this.charges = charges;
    }
}
