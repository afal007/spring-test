package me.afal.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootApp {
    public static void main( String[] args ) {
        new SpringApplicationBuilder()
            .sources( BootApp.class )
            .run( args );
    }
}
