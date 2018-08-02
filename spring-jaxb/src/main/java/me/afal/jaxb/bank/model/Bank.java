package me.afal.jaxb.bank.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "JAXB_BANK")
public class Bank {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 9, unique = true, nullable = false)
    private String BIC;

    @Column(length = 2)
    private String countryCode;

    @Column(nullable = false)
    private boolean active;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "JAXB_SWIFTBIC")
    private List<SwiftBIC> swiftBICs;

    private String name;
    private String country;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive( boolean active ) {
        this.active = active;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC( String BIC ) {
        this.BIC = BIC;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode( String countryCode ) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }

    public List<SwiftBIC> getSwiftBICs() {
        return swiftBICs;
    }

    public void setSwiftBICs( List<SwiftBIC> swiftBICs ) {
        this.swiftBICs = swiftBICs;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Bank bank = (Bank) o;
        return active == bank.active && Objects.equals( BIC, bank.BIC ) && Objects.equals( countryCode, bank.countryCode ) && Objects.equals( swiftBICs, bank.swiftBICs ) && Objects.equals( name, bank.name ) && Objects.equals( country, bank.country );
    }

    @Override
    public int hashCode() {

        return Objects.hash( BIC, countryCode, active, swiftBICs, name, country );
    }
}
