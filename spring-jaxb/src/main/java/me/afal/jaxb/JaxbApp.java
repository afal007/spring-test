package me.afal.jaxb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.afal.jaxb.generated.BankRegistry;

public class JaxbApp {
    public static void main( String[] args ) {
        ApplicationContext ctx          = new ClassPathXmlApplicationContext( "beans.xml" );
        BankRegistryParser parser       = ctx.getBean( "bankRegistryParser", BankRegistryParser.class );
        BankRegistry       bankRegistry = parser.getBankRegistry( "/bank_registry/bankRegistry.xml" );

        System.out.println( bankRegistry );
    }
}
