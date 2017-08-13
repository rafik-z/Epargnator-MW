package com.rafikzebdi.epargnator.domain.composant;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "T_COMPOSANT")
@XmlRootElement
public class Composant implements Serializable {
    private String nom;

    private int montant;

    private int importance;

    public Composant(final String nom, final int montant, final int importance) {
        this.nom = nom;
        this.montant = montant;
        this.importance = importance;
    }

    @Override public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || !(object instanceof Composant)){
            return false;
        }

        final Composant composant = (Composant) object;

        return new EqualsBuilder ()
                .append ( this.montant, composant.montant )
                .append ( this.importance, composant.importance )
                .append ( this.nom, composant.nom )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.nom )
                .append ( this.montant )
                .append ( this.importance )
                .toHashCode ();
    }

    @Override public String toString() {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .append ( "Nom : " + this.nom )
                .append ( "Montant : "+ this.montant )
                .append ( "Importance : "+this.importance )
                .build ();
    }

    @Id
    @Column(name = "COMP_NOM",nullable = false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="COMP_MONTANT", nullable = false)
    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Column(name = "COMP_IMPORTANCE")
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
