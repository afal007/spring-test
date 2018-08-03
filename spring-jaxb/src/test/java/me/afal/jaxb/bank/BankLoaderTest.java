package me.afal.jaxb.bank;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

import me.afal.jaxb.bank.dao.BankRepository;
import me.afal.jaxb.bank.mock.BankRepositoryMock;
import me.afal.jaxb.bank.model.Bank;
import me.afal.jaxb.bank.parse.BankRegistryParser;

import static org.junit.jupiter.api.Assertions.*;

class BankLoaderTest {

    private static BankLoader bankLoader;

    @BeforeAll
    static void setUp() {
        bankLoader = new BankLoader();

        bankLoader.setBankRepository( new BankRepositoryMock() );
        bankLoader.setParser        ( new BankRegistryParser() );

        Logger mock = Mockito.mock( Logger.class );

        BankLoader.setLOG           ( mock );
        BankRegistryParser.setLOG   ( mock );
    }

    private static final String VALID_BANK_REGISTRY_XML = "/xml/validBankRegistry.xml";

    @Test
    void loadBankRegistrySuccess() {
        List<Bank> banks = bankLoader.loadBankRegistry( VALID_BANK_REGISTRY_XML );

        assertNotNull( banks );
        assertTrue( banks.size() == 1 );

        BankRepository bankRepository = bankLoader.getBankRepository();
        assertEquals( 1, bankRepository.count() );
    }
}