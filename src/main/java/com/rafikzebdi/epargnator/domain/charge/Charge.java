package com.rafikzebdi.epargnator.domain.charge;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(final Object object) {
        if (this == object){
            return true;
        }

        if (object == null || getClass () != object.getClass ()){
            return false;
        }

        final Charge charge = (Charge) object;

        return new EqualsBuilder ()
                .append ( this.montant, charge.montant )
                .append ( this.name, charge.name )
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder ( 17, 37 )
                .append ( this.name )
                .append ( this.montant )
                .build();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(this.name)
                .append(this.montant)
                .build();
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
