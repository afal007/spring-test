package me.afal.spring.test;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class GreetingAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization( Object bean, String beanName ) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            Greeting annotation = field.getAnnotation( Greeting.class );
            if ( annotation != null ) {
                String firstName = annotation.firstName();
                String lastName  = annotation.lastName();
                field.setAccessible( true );
                ReflectionUtils.setField( field, bean, firstName + " " + lastName );
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization( Object bean, String beanName ) throws BeansException {
        return bean;
    }
}
