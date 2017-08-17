package com.rafikzebdi.epargnator.domain.projet;

import com.rafikzebdi.epargnator.domain.composant.Composant;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_PROJET")
@XmlRootElement
public class Projet implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private List<Composant> composants;
    private Date dateLimite;

    public Projet() {
        super();
    }

    public Projet(String name, List <Composant> composants, Date dateLimite) {
        this.name = name;
        this.composants = composants;
        this.dateLimite = dateLimite;
    }

    @Override public String toString() {
        return "Projet{" +
                "name='" + name + '\'' +
                ", composants=" + composants +
                ", dateLimite=" + dateLimite +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Projet projet = (Projet) o;

        return new EqualsBuilder ()
                .append ( name, projet.name )
                .append ( composants, projet.composants )
                .append ( dateLimite, projet.dateLimite )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( composants )
                .append ( dateLimite )
                .toHashCode ();
    }

    @Id
    @Column(name = "PRJ_NOM", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinTable(
            name = "T_PROJET_COMPOSANT",
            joinColumns = @JoinColumn(name = "PROJ_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMP_ID")
    )

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List <Composant> composants) {
        this.composants = composants;
    }

    @Column(name="PRJ_DATE")
    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }
}
