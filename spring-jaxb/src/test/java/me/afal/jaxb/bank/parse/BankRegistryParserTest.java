package me.afal.jaxb.bank.parse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import me.afal.jaxb.generated.BankRegistry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankRegistryParserTest {

    private static BankRegistryParser parser;

    @BeforeAll
    static void beforeClass() {
        parser = new BankRegistryParser();
        BankRegistryParser.setLOG( Mockito.mock( Logger.class ) );
    }

    private static final String VALID_BANK_REGISTRY_XML = "/xml/validBankRegistry.xml";

    @Test
    void getBankRegistrySuccess() {
        Optional<BankRegistry> bankRegistry = parser.getBankRegistry( VALID_BANK_REGISTRY_XML );

        // Must be one root element
        assertTrue( bankRegistry.isPresent() );

        BankRegistry            innerBankRegistry = bankRegistry.get();
        List<BankRegistry.Bank> bankList          = innerBankRegistry.getBankList();

        // Must be exactly one Bank element
        assertNotNull( bankList );
        assertTrue( bankList.size() == 1 );

        BankRegistry.Bank bank = bankList.get( 0 );

        // Validate Bank fields
        assertTrue( bank.isActive() );
        assertEquals( "bic",    bank.getBIC() );
        assertEquals( "Russia", bank.getCountry().getValue() );
        assertEquals( "RU",     bank.getCountry().getCode() );
        assertEquals( "Bank",   bank.getName() );

        List<BankRegistry.Bank.SwiftBICs> swiftBICList = bank.getSwiftBICs();

        // Must be exactly one SwiftBICs element
        assertNotNull( swiftBICList );
        assertTrue( swiftBICList.size() == 1 );

        BankRegistry.Bank.SwiftBICs swiftBIC = swiftBICList.get( 0 );

        // Validate SwiftBICs value
        assertEquals( "swiftBIC1", swiftBIC.getValue() );
    }

    private static final String INVALID_BANK_REGISTRY_XML = "/xml/invalidBankRegistry.xml";

    @Test
    void getBankRegistryError() {
        String errMessage = BankRegistryParser.unmarshallerError( INVALID_BANK_REGISTRY_XML );
        assertThrows(
            RuntimeException.class,
            () -> parser.getBankRegistry( INVALID_BANK_REGISTRY_XML ),
            errMessage
        );
    }
}