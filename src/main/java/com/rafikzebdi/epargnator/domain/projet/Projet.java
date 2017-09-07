package com.rafikzebdi.epargnator.domain.projet;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_PROJET")
@XmlRootElement
public class Projet implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private Composant c1;
    private Composant c2;
    private Composant c3;
    private Composant c4;
    private Composant c5;
    private Date dateLimite;

    public Projet() {
        super();
    }

    public Projet(String name, Date dateLimite) {
        this.name = name;
        this.c1 = null;
        this.c2 = null;
        this.c3 = null;
        this.c4 = null;
        this.c5 = null;
        this.dateLimite = dateLimite;
    }

    public Projet(String name, Composant c1, Date dateLimite) {
        this.name = name;
        this.c1 = c1;
        this.c2 = null;
        this.c3 = null;
        this.c4 = null;
        this.c5 = null;
        this.dateLimite = dateLimite;
    }

    public Projet(String name, Composant c1,Composant c2, Date dateLimite) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = null;
        this.c4 = null;
        this.c5 = null;
        this.dateLimite = dateLimite;
    }

    public Projet(String name, Composant c1,Composant c2,Composant c3, Date dateLimite) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = null;
        this.c5 = null;
        this.dateLimite = dateLimite;
    }

    public Projet(String name, Composant c1,Composant c2,Composant c3,Composant c4,Date dateLimite) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = null;
        this.dateLimite = dateLimite;
    }

    public Projet(String name, Composant c1,Composant c2,Composant c3,Composant c4,Composant c5, Date dateLimite) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.dateLimite = dateLimite;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Projet projet = (Projet) o;

        return new EqualsBuilder ()
                .append ( name, projet.name )
                .append ( c1, projet.c1 )
                .append ( c2, projet.c2 )
                .append ( c3, projet.c3 )
                .append ( c4, projet.c4 )
                .append ( c5, projet.c5 )
                .append ( dateLimite, projet.dateLimite )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( c1 )
                .append ( c2 )
                .append ( c3 )
                .append ( c4 )
                .append ( c5 )
                .append ( dateLimite )
                .toHashCode ();
    }

    @Override public String toString() {
        return "Projet{" +
                "name='" + name + '\'' +
                ", c1=" + c1 +
                ", c2=" + c2 +
                ", c3=" + c3 +
                ", c4=" + c4 +
                ", c5=" + c5 +
                ", dateLimite=" + dateLimite +
                '}';
    }

    @Id
    @Column(name = "PRJ_NOM", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="PRJ_C1", nullable = true)
    public Composant getC1() {
        return c1;
    }

    public void setC1(Composant c1) {
        this.c1 = c1;
    }
    @Column(name="PRJ_C2", nullable = true)
    public Composant getC2() {
        return c2;
    }

    public void setC2(Composant c2) {
        this.c2 = c2;
    }
    @Column(name="PRJ_C3", nullable = true)
    public Composant getC3() {
        return c3;
    }

    public void setC3(Composant c3) {
        this.c3 = c3;
    }
    @Column(name="PRJ_C4", nullable = true)
    public Composant getC4() {
        return c4;
    }

    public void setC4(Composant c4) {
        this.c4 = c4;
    }
    @Column(name="PRJ_C5", nullable = true)
    public Composant getC5() {
        return c5;
    }

    public void setC5(Composant c5) {
        this.c5 = c5;
    }

    @Column(name="PRJ_DATE")
    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
}
