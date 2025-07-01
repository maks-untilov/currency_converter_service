package currency.converter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<String> handleExternalApiError() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Сервис курсов валют недоступен");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationError() {
        return ResponseEntity.badRequest().body("Неверные параметры запроса");
    }
}