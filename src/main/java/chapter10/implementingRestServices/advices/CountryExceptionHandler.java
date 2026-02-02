package chapter10.implementingRestServices.advices;

import chapter10.implementingRestServices.models.exceptions.CountryNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CountryExceptionHandler {
    @ExceptionHandler(CountryNullException.class)
    public ResponseEntity<String> testingExceptionHandler() {
        return ResponseEntity.status(HttpStatus.OK).body("ok!");
    }
}
