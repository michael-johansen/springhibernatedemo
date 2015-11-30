package di.advanced;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class ComponentScanConflictResolutionDemo {
    private static final Logger log = LoggerFactory.getLogger(ComponentScanConflictResolutionDemo.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        log.info(":" + context.getBean(MyInterface1.class));
        log.info(":" + context.getBean("myInterface1Impl2", MyInterface1.class));
        //log.info(":" + context.getBean(MyInterface2.class));// Will fail -> ambiguous
        log.info(":" + context.getBean("1", MyInterface2.class));
        log.info(":" + context.getBean("2", MyInterface2.class));
//        log.info(":" + context.getBean(MyInterface3.class));// Will fail -> ambiguous
        log.info(":" + context.getBean("myInterface3Impl1", MyInterface3.class));
        log.info(":" + context.getBean("myInterface3Impl2", MyInterface3.class));
    }

    @Configuration
    @ComponentScan(/** default is current package*/)
    public static class MyConfiguration {
        @Autowired private MyInterface1 myInterface11;
        @Autowired @Qualifier("myInterface1Impl2") private MyInterface1 myInterface12;
        @Autowired @Qualifier("1") private MyInterface2 myInterface21;
        @Autowired @Qualifier("2") private MyInterface2 myInterface22;
        @Autowired @Qualifier("myInterface3Impl1") private MyInterface3 myInterface31;
        @Autowired @MyPreferred private MyInterface3 myInterface32;
    }

}
