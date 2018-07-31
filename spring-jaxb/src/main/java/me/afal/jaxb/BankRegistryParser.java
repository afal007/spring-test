package me.afal.jaxb;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import me.afal.jaxb.generated.BankRegistry;

public class BankRegistryParser {

    public static final Marker MARKER = MarkerFactory.getMarker( BankRegistryParser.class.getSimpleName() );

    @Log
    private static Logger LOG;

    public BankRegistry getBankRegistry( String fileName ) {
        LOG.info( MARKER, "{}", fileName );
        try {
            JAXBContext  context          = JAXBContext.newInstance( BankRegistry.class );
            Unmarshaller unmarshaller     = context.createUnmarshaller();
            InputStream  resourceAsStream = BankRegistryParser.class.getResourceAsStream( fileName );

            return (BankRegistry) unmarshaller.unmarshal( resourceAsStream );
        } catch ( JAXBException e ) {
            String err = unmarshalError( fileName );
            LOG.error( MARKER, err, e );
            throw new RuntimeException( err, e );
    }   }

    public static final String UNMARSHAL_ERR = "Не удалось обработать документ";

    private String unmarshalError( String fileName ) {
        return UNMARSHAL_ERR + Const.SPACE + fileName;
    }
}
