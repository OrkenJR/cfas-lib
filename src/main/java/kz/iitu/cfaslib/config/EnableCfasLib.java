package kz.iitu.cfaslib.config;

import kz.iitu.cfaslib.CfasLibApplication;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CfasLibApplication.class)
public @interface EnableCfasLib {
}