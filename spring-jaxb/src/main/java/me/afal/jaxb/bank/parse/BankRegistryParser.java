package me.afal.jaxb.bank.parse;

import java.io.InputStream;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import me.afal.jaxb.Const;
import me.afal.jaxb.bank.BankMapper;
import me.afal.jaxb.spring.annotation.Log;
import me.afal.jaxb.generated.BankRegistry;

public class BankRegistryParser {

    public static final Marker MARKER = MarkerFactory.getMarker( BankRegistryParser.class.getSimpleName() );

    @Log
    private static Logger LOG;

    public Optional<BankRegistry> getBankRegistry( String fileName ) {
        LOG.info( MARKER, "{}", fileName );
        try {
            JAXBContext  context          = JAXBContext.newInstance( BankRegistry.class );
            Unmarshaller unmarshaller     = context.createUnmarshaller();
            InputStream  resourceAsStream = BankRegistryParser.class.getResourceAsStream( fileName );

            return Optional.ofNullable( (BankRegistry) unmarshaller.unmarshal( resourceAsStream ) );
        } catch ( JAXBException e ) {
            String err = unmarshallerError( fileName );

            LOG.error( MARKER, err, e );
            throw new RuntimeException( err, e );
    }   }

    public static final String UNMARSHALLER_ERR = "Не удалось обработать документ";

    public static String unmarshallerError( String fileName ) {
        return UNMARSHALLER_ERR + Const.SPACE + fileName;
    }

    public static Logger getLOG() {
        return LOG;
    }

    public static void setLOG( Logger LOG ) {
        BankRegistryParser.LOG = LOG;
    }
}
