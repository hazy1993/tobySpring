package tobyspring.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloServiceTest {
    @Test
    void simpleHelloService(){
        SimpleHelloService helloService = new SimpleHelloService();

        String ret = helloService.sayHello("Test");

        assertThat(ret).isEqualTo("HelloTest");
    }

    @Test
    void HelloDecorator(){
        HelloDecorator helloDecorator = new HelloDecorator(name ->name );
        String ret = helloDecorator.sayHello("Test");
        assertThat(ret).isEqualTo("*Test*");
    }
}
