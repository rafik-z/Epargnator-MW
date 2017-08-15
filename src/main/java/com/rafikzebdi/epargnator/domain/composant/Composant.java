package com.rafikzebdi.epargnator.domain.composant;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "T_COMPOSANT")
@XmlRootElement
public class Composant implements Serializable {
    private static final long serialVersionUID = 1L;
    private int composant_id;
    private String name;

    private int montant;

    private int importance;

    public Composant(){
        super();
    }

    public Composant(final int composant_id, final String name, final int montant, final int importance) {
        this.composant_id = composant_id;
        this.name = name;
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
                .append ( this.composant_id, composant.composant_id )
                .append ( this.montant, composant.montant )
                .append ( this.importance, composant.importance )
                .append ( this.name, composant.name )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.composant_id )
                .append ( this.name )
                .append ( this.montant )
                .append ( this.importance )
                .toHashCode ();
    }

    @Override public String toString() {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .append ( "ID : " + this.composant_id )
                .append ( "Nom : " + this.name )
                .append ( "Montant : "+ this.montant )
                .append ( "Importance : "+this.importance )
                .build ();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getComposant_id() {
        return composant_id;
    }

    public void setComposant_id(int composant_id) {
        this.composant_id = composant_id;
    }



    @Column(name = "COMP_NOM",nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="COMP_MONTANT", nullable = true)
    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Column(name = "COMP_IMPORTANCE", nullable = true)
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
