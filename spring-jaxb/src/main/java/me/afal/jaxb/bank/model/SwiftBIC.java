package me.afal.jaxb.bank.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SwiftBIC {

    @Column(length = 9, nullable = false)
    private String swiftBIC;

    @Column(nullable = false)
    private boolean active;

    public String getSwiftBIC() {
        return swiftBIC;
    }

    public void setSwiftBIC( String swiftBIC ) {
        this.swiftBIC = swiftBIC;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive( boolean active ) {
        this.active = active;
    }
}
