package layered;

import layered.service.AppConfig;
import layered.web.WebConfig;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class InitializeWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    public InitializeWebApp() {
        LoggerFactory.getLogger(getClass()).info("Initializing");
    }

    @Override
    protected String getServletName() {
        return "layered-demo";
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                AppConfig.class
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
