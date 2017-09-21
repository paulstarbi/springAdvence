package beans.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String exceptionController(Exception ex, Model model) {
        model.addAttribute("message", ex.toString());

        return "exception";
    }

    @ExceptionHandler (NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String httpNotFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("message", ex.toString());

        return "exception";
    }
}

