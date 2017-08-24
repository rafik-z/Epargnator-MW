package com.rafikzebdi.epargnator.domain.charge;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "T_CHARGES")
@XmlRootElement
public class Charge {

    private String name;
    private int montant;

    public Charge(){
        super();
    }

    public Charge(final String name,final int montant) {
        super();
        this.name = name;
        this.montant = montant;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass () != o.getClass ()) return false;

        Charge charge = (Charge) o;

        return new EqualsBuilder ()
                .append ( montant, charge.montant )
                .append ( name, charge.name )
                .isEquals ();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( name )
                .append ( montant )
                .toHashCode ();
    }

    @Override public String toString() {
        return "Charge{" +
                "name='" + name + '\'' +
                ", montant=" + montant +
                '}';
    }

    @Id
    @Column(name = "CHA_NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CHA_MONTANT")
    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
