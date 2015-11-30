package exercise;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitializeWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    public InitializeWebApp() {
        LoggerFactory.getLogger(getClass()).info("Initializing");
    }

    @Override
    protected String getServletName() {
        return "exercise";
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                // TODO: Add app configuration
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                // TODO: Add web configuration
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
