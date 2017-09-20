package beans.exception;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class MyExceptionHandler extends SimpleMappingExceptionResolver {

    @Override
    public void setDefaultErrorView(String defaultErrorView) {
        ;
    }
}
