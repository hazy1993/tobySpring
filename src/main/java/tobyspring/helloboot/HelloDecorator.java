package tobyspring.helloboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary //같은 클레스 타입의 빈이 있을경우, 우선순위 로 지정
public class HelloDecorator implements HelloService{
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }
    @Override
    public String sayHello(String name) {
        return "*"+helloService.sayHello(name)+"*";
    }
}
