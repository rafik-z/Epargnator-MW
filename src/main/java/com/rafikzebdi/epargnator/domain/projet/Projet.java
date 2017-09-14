package com.rafikzebdi.epargnator.domain.projet;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_PROJET")
@XmlRootElement
public class Projet implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private List<Composant> composantsProjet;
    private Date dateLimite;

    public Projet() {
        super();
    }

    public Projet(final String name, final List <Composant> composantsProjet, final Date dateLimite) {
        this.name = name;
        this.composantsProjet = composantsProjet;
        this.dateLimite = dateLimite;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Projet projet = (Projet) o;

        return new EqualsBuilder ()
                .append ( name, projet.name )
                .append ( this.composantsProjet, projet.composantsProjet )
                .append ( dateLimite, projet.dateLimite )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.name )
                .append ( this.composantsProjet )
                .append ( this.dateLimite )
                .toHashCode ();
    }

    @Override public String toString() {
        return "Projet{" +
                "name='" + this.name + '\'' +
                ", composants=" + this.composantsProjet+
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

    @ElementCollection(targetClass = Composant.class, fetch = FetchType.EAGER)
    public List <Composant> getComposantsProjet() {
        return composantsProjet;
    }

    public void setComposantsProjet(List <Composant> composantsProjet) {
        this.composantsProjet = composantsProjet;
    }

    @Column(name="PRJ_DATE")
    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
}
