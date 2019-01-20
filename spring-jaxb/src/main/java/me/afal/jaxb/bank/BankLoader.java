package me.afal.jaxb.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import me.afal.jaxb.bank.model.Bank;
import me.afal.jaxb.bank.model.SwiftBIC;
import me.afal.jaxb.bank.parse.BankRegistryParser;
import me.afal.jaxb.generated.BankRegistry;
import me.afal.jaxb.spring.annotation.Log;
import me.afal.jaxb.bank.dao.BankRepository;

public class BankLoader {

    private static final Marker MARKER = MarkerFactory.getMarker( BankLoader.class.getSimpleName() );

    @Log
    private static Logger LOG;

    private BankMapper bankMapper;

    private BankRepository bankRepository;

    private BankRegistryParser parser;

    public List<Bank> loadBankRegistry( String fileName ) {
        LOG.info( MARKER, "Trying to load bank registry from {}", fileName );
        Optional<BankRegistry> bankRegistry = parser.getBankRegistry( fileName );
        List<Bank> bankList = new ArrayList<>();

        bankRegistry.ifPresent( innerBankRegistry -> {
            LOG.info( MARKER, "Bank registry is not empty" );
            List<BankRegistry.Bank> bankRegistryList = innerBankRegistry.getBankList();

            for ( BankRegistry.Bank registryBank : bankRegistryList ) {
                Bank bank = bankMapper.map( registryBank );
                bankList.add( bank );
                bankRepository.save( bank );
            }
        } );

        return bankList;
    }

    public BankRepository getBankRepository() {
        return bankRepository;
    }

    public void setBankRepository( BankRepository bankRepository ) {
        this.bankRepository = bankRepository;
    }

    public BankRegistryParser getParser() {
        return parser;
    }

    public void setParser( BankRegistryParser parser ) {
        this.parser = parser;
    }

    public BankMapper getBankMapper() {
        return bankMapper;
    }

    public void setBankMapper( BankMapper bankMapper ) {
        this.bankMapper = bankMapper;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG( Logger LOG ) {
        BankLoader.LOG = LOG;
    }
}
