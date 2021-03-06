package helloworld;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import helloworld.root.RootConfig;
import helloworld.web.WebConfig;

public class InitializeWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
    public InitializeWebApp() {
        LoggerFactory.getLogger(getClass()).info("Initializing");
    }

    @Override
    protected String getServletName() {
        return "helloWorldApp";
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
