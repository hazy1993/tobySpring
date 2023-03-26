package tobyspring.helloboot;


import config.autoconfig.DispatcherServletConfig;
import config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //TYPE 은 클레스, 인터페이스 , ENUM
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan
@Import({TomcatWebServerConfig.class,DispatcherServletConfig.class})
public @interface MySpringBootApplication {

}
