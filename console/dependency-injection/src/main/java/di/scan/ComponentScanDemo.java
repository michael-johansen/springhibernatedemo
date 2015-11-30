package di.scan;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class ComponentScanDemo {
    private static final Logger log = LoggerFactory.getLogger(ComponentScanDemo.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        log.info(":" + context.getBean(MyInterface.class));
        log.info(":" + context.getBean(MyRepository.class));
        log.info(":" + context.getBean(MyService.class));
        log.info(":" + context.getBean(MyController.class));
    }

    @Configuration
    @ComponentScan(/** default is current package*/)
    public static class MyConfiguration {

    }
}
