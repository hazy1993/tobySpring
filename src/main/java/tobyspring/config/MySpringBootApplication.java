package tobyspring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //TYPE 은 클레스, 인터페이스 , ENUM
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
@EnableMyAutoConfigration
public @interface MySpringBootApplication {

}
