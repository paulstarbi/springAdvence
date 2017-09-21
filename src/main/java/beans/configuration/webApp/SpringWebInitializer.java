package beans.configuration.webApp;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringMvcConfiguration.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        ServletRegistration.Dynamic servletRegistration
                = servletContext.addServlet("dispatcher", dispatcherServlet);

        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        servletContext.addFilter("characterEncodingFilter", characterEncodingFilter)
                .addMappingForUrlPatterns(null, true, "/*");
    }
}
