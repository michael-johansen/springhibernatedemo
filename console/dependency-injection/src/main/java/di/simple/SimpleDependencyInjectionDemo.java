package di.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SimpleDependencyInjectionDemo {
    private static final Logger log = LoggerFactory.getLogger(SimpleDependencyInjectionDemo.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyRepository.class, MyService.class);
        context.refresh();

        MyService myService = context.getBean(MyService.class);
        log.info("myService: " + myService);
        log.info("myService.myRepository1: " + myService.myRepository1);
        log.info("myService.myRepository2: " + myService.myRepository2);
        Arrays.asList(context.getBeanDefinitionNames()).forEach(log::info);
    }

    static class MyRepository {
    }

    static class MyService {
        private final MyRepository myRepository1;
        private MyRepository myRepository2;

        @Autowired // Constructor injection, great for fields that should be final
        MyService(MyRepository myRepository1) {
            this.myRepository1 = myRepository1;
        }

        @Autowired // Setter injection
        void setMyRepository2(MyRepository myRepository2) {
            this.myRepository2 = myRepository2;
        }
    }
}
