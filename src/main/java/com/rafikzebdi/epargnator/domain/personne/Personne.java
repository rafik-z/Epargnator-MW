package com.rafikzebdi.epargnator.domain.personne;

import com.rafikzebdi.epargnator.domain.charge.Charge;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_PERSONNE")
@XmlRootElement
public class Personne implements Serializable{

    private int id;
    private String name;
    private Date dateCreation;
    private Date dateMiseAJour;
    private int revenu;
    private List<Charge> chargesPersonne;

    public Personne(){
        super();
    }

    public Personne(final String name) {
        super();
        this.name = name;
        this.dateCreation = Date.from ( Instant.now () );
        this.dateMiseAJour = Date.from ( Instant.now () );
        this.revenu = 0;
        this.chargesPersonne = null;
    }

    public Personne(final String name, final int revenu) {
        super();
        this.name = name;
        this.dateCreation = Date.from ( Instant.now () );
        this.dateMiseAJour = Date.from ( Instant.now () );
        this.revenu = revenu;
    }

    @Override public String toString() {
        return new ToStringBuilder ( this )
                .append ( "Personne{" )
                .append ( "id = '"+this.id )
                .append ( "name = '"+this.name )
                .append ( "' , dateCreation = '"+this.dateCreation )
                .append ( "' , dateMAJ = '"+this.dateMiseAJour )
                .append ( "', revenu = '"+this.revenu+"'}" )
                .build ();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Personne personne = (Personne) o;

        return new EqualsBuilder ()
                .append ( this.id, personne.id )
                .append ( this.revenu, personne.revenu )
                .append ( this.name, personne.name )
                .append ( this.dateCreation, personne.dateCreation )
                .append ( this.dateMiseAJour, personne.dateMiseAJour )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.id )
                .append ( this.name )
                .append ( this.dateCreation )
                .append ( this.dateMiseAJour )
                .append ( this.revenu )
                .toHashCode ();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PER_ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "PER_NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PER_DATE_CREA")
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Column(name = "PER_DATE_MAJ")
    public Date getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(Date dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    @Column(name = "PER_REVENU", nullable = true)
    public int getRevenu() {
        return revenu;
    }

    public void setRevenu(int revenu) {
        this.revenu = revenu;
    }

    @ElementCollection(targetClass = Charge.class, fetch = FetchType.EAGER)
    public List<Charge> getChargesPersonne() {
        return chargesPersonne;
    }

    public void setChargesPersonne(List<Charge> chargesPersonne) {
        this.chargesPersonne = chargesPersonne;
    }
}
