package me.afal.jaxb.bank;

import java.util.ArrayList;
import java.util.List;

import me.afal.jaxb.bank.model.Bank;
import me.afal.jaxb.bank.model.SwiftBIC;
import me.afal.jaxb.generated.BankRegistry;

public class BankMapper {
    public Bank map( BankRegistry.Bank registryBank ) {
        Bank bank = new Bank();

        List<SwiftBIC> swiftBICList = new ArrayList<>();
        for( BankRegistry.Bank.SwiftBICs registrySwiftBIC : registryBank.getSwiftBICs() ) {
            SwiftBIC swiftBIC = new SwiftBIC();

            swiftBIC.setActive      ( registrySwiftBIC.isDefault() );
            swiftBIC.setSwiftBIC    ( registrySwiftBIC.getValue() );

            swiftBICList.add( swiftBIC );
        }

        bank.setActive      ( registryBank.isActive() );
        bank.setBIC         ( registryBank.getBIC() );
        bank.setCountry     ( registryBank.getCountry().getValue() );
        bank.setCountryCode ( registryBank.getCountry().getCode() );
        bank.setName        ( registryBank.getName() );
        bank.setSwiftBICs   ( swiftBICList );

        return bank;
    }
}
