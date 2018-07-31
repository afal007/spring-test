package me.afal.spring.test;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class Bean{

    @Greeting( firstName = "Sania", lastName = "Fal" )
    private String fullName;

    private Bean bean;                                      // Self injecting

    public Bean() {
        System.out.println( "Constructor " + fullName );    // fullName is null cause BeansPostProcessors haven't done their work yet
    }

    public String greeting( String name ) {
        return "Hello, " + fullName;                        // fullName was initialized by BeanPostProcessor
    }

    @PostConstruct
    public void init() {
        System.out.println( "Init method " + bean.greeting( fullName ) );    // fullName was initialized by BeanPostProcessor
    }

    public void setBean( Bean bean ) {
        this.bean = bean;
    }

    public Bean getBean() {
        return bean;
    }
}
