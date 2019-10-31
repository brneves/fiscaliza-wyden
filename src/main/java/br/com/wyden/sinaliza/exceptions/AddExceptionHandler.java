package br.com.wyden.sinaliza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AddExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<TemplateError> notFound(ObjectNotFoundException e, HttpServletRequest infoRequest){
        TemplateError erro = new TemplateError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

}
