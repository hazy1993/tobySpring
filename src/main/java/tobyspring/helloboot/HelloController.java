package tobyspring.helloboot;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class HelloController implements ApplicationContextAware {
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name){

        //IllegalArgumentException null이나 공백일 경우 많이 처리하는 예외
        if(name==null || name.trim().length() == 0) throw new IllegalArgumentException();

        return helloService.sayHello(name);
        //Objects.requireNonNull name 이 null이면 Exception 발생
        // return helloService.sayHello(Objects.requireNonNull(name));
    }
    /*@GetMapping("/hello")
    public String hello(HttpServletResponse response,String name)throws Exception{
        return helloService.sayHello(Objects.requireNonNull(name));
    }*/
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContextapplicationContext");

        System.out.println(applicationContext);
    }
}
