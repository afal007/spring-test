package me.afal.jaxb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.afal.jaxb.bank.BankLoader;
import me.afal.jaxb.bank.model.Bank;

public class JaxbApp {

    public static void main( String[] args ) {
        ApplicationContext ctx        = new ClassPathXmlApplicationContext( "beans.xml" );
        BankLoader         bankLoader = ctx.getBean( "bankLoader", BankLoader.class );
        List<Bank>         bankList   = bankLoader.loadBankRegistry( "/bank_registry/bankRegistry.xml" );

        System.out.println( bankList );
    }

}
