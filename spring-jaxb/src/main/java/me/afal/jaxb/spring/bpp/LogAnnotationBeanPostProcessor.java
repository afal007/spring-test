package me.afal.jaxb.spring.bpp;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import me.afal.jaxb.spring.annotation.Log;

public class LogAnnotationBeanPostProcessor implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization( Object bean, String beanName ) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for ( Field field : fields ) {
            Log annotation = field.getAnnotation( Log.class );
            if( annotation != null ) {
                Logger logger = LoggerFactory.getLogger( bean.getClass() );

                ReflectionUtils.makeAccessible( field );
                ReflectionUtils.setField( field, bean, logger );
        }   }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization( Object bean, String beanName ) throws BeansException {
        return bean;
    }
}
