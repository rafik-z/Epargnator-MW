package com.rafikzebdi.epargnator.domain;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
public class ProjetTO implements Serializable{
    private String name;
    private Date dateLimite;
    private Composant composant_1;
    private Composant composant_2;
    private Composant composant_3;
    private Composant composant_4;
    private Composant composant_5;

    public ProjetTO() {
    }

    public ProjetTO(String name, Date dateLimite) {
        this.name = name;
        this.dateLimite = dateLimite;
    }

    public ProjetTO(String name, Date dateLimite, Composant composant_1) {
        this.name = name;
        this.dateLimite = dateLimite;
        this.composant_1 = composant_1;
    }

    public ProjetTO(String name, Date dateLimite, Composant composant_1,
                    Composant composant_2) {
        this.name = name;
        this.dateLimite = dateLimite;
        this.composant_1 = composant_1;
        this.composant_2 = composant_2;
    }

    public ProjetTO(String name, Date dateLimite, Composant composant_1,
                    Composant composant_2, Composant composant_3) {
        this.name = name;
        this.dateLimite = dateLimite;
        this.composant_1 = composant_1;
        this.composant_2 = composant_2;
        this.composant_3 = composant_3;
    }

    public ProjetTO(String name, Date dateLimite, Composant composant_1,
                    Composant composant_2, Composant composant_3,
                    Composant composant_4) {
        this.name = name;
        this.dateLimite = dateLimite;
        this.composant_1 = composant_1;
        this.composant_2 = composant_2;
        this.composant_3 = composant_3;
        this.composant_4 = composant_4;
    }

    public ProjetTO(String name, Date dateLimite, Composant composant_1,
                    Composant composant_2, Composant composant_3,
                    Composant composant_4, Composant composant_5) {
        this.name = name;
        this.dateLimite = dateLimite;
        this.composant_1 = composant_1;
        this.composant_2 = composant_2;
        this.composant_3 = composant_3;
        this.composant_4 = composant_4;
        this.composant_5 = composant_5;
    }

    @Override public String toString() {
        return "ProjetTO{" +
                "name='" + name + '\'' +
                ", dateLimite=" + dateLimite +
                ", composant_1=" + composant_1 +
                ", composant_2=" + composant_2 +
                ", composant_3=" + composant_3 +
                ", composant_4=" + composant_4 +
                ", composant_5=" + composant_5 +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        ProjetTO projetTO = (ProjetTO) o;

        return new EqualsBuilder ()
                .append ( name, projetTO.name )
                .append ( dateLimite, projetTO.dateLimite )
                .append ( composant_1, projetTO.composant_1 )
                .append ( composant_2, projetTO.composant_2 )
                .append ( composant_3, projetTO.composant_3 )
                .append ( composant_4, projetTO.composant_4 )
                .append ( composant_5, projetTO.composant_5 )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( dateLimite )
                .append ( composant_1 )
                .append ( composant_2 )
                .append ( composant_3 )
                .append ( composant_4 )
                .append ( composant_5 )
                .toHashCode ();
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public Composant getComposant_1() {
        return composant_1;
    }

    public void setComposant_1(Composant composant_1) {
        this.composant_1 = composant_1;
    }

    public Composant getComposant_2() {
        return composant_2;
    }

    public void setComposant_2(Composant composant_2) {
        this.composant_2 = composant_2;
    }

    public Composant getComposant_3() {
        return composant_3;
    }

    public void setComposant_3(Composant composant_3) {
        this.composant_3 = composant_3;
    }

    public Composant getComposant_4() {
        return composant_4;
    }

    public void setComposant_4(Composant composant_4) {
        this.composant_4 = composant_4;
    }

    public Composant getComposant_5() {
        return composant_5;
    }

    public void setComposant_5(Composant composant_5) {
        this.composant_5 = composant_5;
    }
}
