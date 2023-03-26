package tobyspring.helloboot;


import tobyspring.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;


@MySpringBootApplication
public class HellobootApplication {
/*Config Class로 이동

  @Bean
public ServletWebServerFactory servletWebServerFactory(){
    return new TomcatServletWebServerFactory();
}
    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }
 */

    public static void main(String[] args) {
      // MySpringApplication.run(HellobootApplication.class,args);
        SpringApplication.run(HellobootApplication.class,args);

    }


/*
Component 스캔 사용 전
@Configuration
public class HellobootApplication {
    @Bean
    public HelloController helloController(HelloService helloService){
        return new HelloController(helloService);
    }

    @Bean
    public HelloService helloService(){
        return new SimpleHelloService();
    }

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(){
            @Override
            protected void onRefresh() {
                super.onRefresh();
                ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {

                    servletContext.addServlet("dispatcherServlet", new DispatcherServlet(this) {

                    }).addMapping("/*");
                });
                webServer.start();
            }
        };
        applicationContext.register(HellobootApplication.class);
        applicationContext.refresh();

    }*/

    /*DispatcherServlet AsIs
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean(HelloController.class);
        applicationContext.registerBean(SimpleHelloService.class);
        applicationContext.refresh();

        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {

            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    //인증, 보안, 다국어 처리리
                    if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())){
                      String name = req.getParameter("name");

                        HelloController helloController = applicationContext.getBean(HelloController.class);
                        String ret = helloController.hello(name);

                      resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                      resp.getWriter().print(ret);
                    }else{
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });
        webServer.start();
    }*/
}
