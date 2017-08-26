package com.rafikzebdi.epargnator.domain.personne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "T_PERSONNE")
@XmlRootElement
public class Personne implements Serializable{

    private String name;
    private Date dateCreation;
    private Date dateMiseAJour;
    private int revenu;
    private DateFormat df = new SimpleDateFormat ( "dd/MM/yy" );

    public Personne(){
        super();
    }

    public Personne(String name) {
        super();
        this.name = name;
        this.dateCreation = Date.from ( Instant.now () );
        this.dateMiseAJour = Date.from ( Instant.now () );
        this.revenu = 0;
    }

    public Personne(String name, int revenu) {
        super();
        this.name = name;
        this.dateCreation = Date.from ( Instant.now () );
        this.dateMiseAJour = Date.from ( Instant.now () );
        this.revenu = revenu;
    }

    @Override public String toString() {
        return new ToStringBuilder ( this )
                .append ( "Personne{" )
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
                .append ( revenu, personne.revenu )
                .append ( name, personne.name )
                .append ( dateCreation, personne.dateCreation )
                .append ( dateMiseAJour, personne.dateMiseAJour )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( dateCreation )
                .append ( dateMiseAJour )
                .append ( revenu )
                .toHashCode ();
    }

    @Id
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
}
