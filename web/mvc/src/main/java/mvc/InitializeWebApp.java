package mvc;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import mvc.model.RootConfig;
import mvc.web.ServletConfig;

public class InitializeWebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    public InitializeWebApp() {
        LoggerFactory.getLogger(getClass()).info("Initializing");
    }

    @Override
    protected String getServletName() {
        return "mvc-demo";
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
                ServletConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
