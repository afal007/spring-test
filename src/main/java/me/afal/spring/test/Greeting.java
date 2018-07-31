package me.afal.spring.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME )
public @interface Greeting {

    String firstName();
    String lastName();
}
