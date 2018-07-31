package me.afal.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class XmlApp {
    public static void main( String[] args ) {

//        ApplicationContext ctx = new AnnotationConfigApplicationContext( "me.afal.spring.test" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext( "beans.xml" );

        Bean bean = ctx.getBean( "bean", Bean.class );
        System.out.println( bean.greeting( "Sania" ) );

        List<Object> objects = new ArrayList<>();
    }
}
