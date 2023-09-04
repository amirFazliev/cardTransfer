package hm.cardtransfer.exception;

import hm.cardtransfer.responce.ResponceError;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestControllerAdvice
public class ExceptionHandlerAdviceApp {
    private final AtomicInteger idException = new AtomicInteger(0);

    @ExceptionHandler(ResponceError.class)
    public ResponseEntity<Object> authHandlerServerException (ResponceError e) {
        e.setId(idException.incrementAndGet());
        return new ResponseEntity<>(e, HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> authHandlerMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        String message = (String) Objects.requireNonNull(e.getDetailMessageArguments())[1];
        ResponceError error = new ResponceError(message, idException.incrementAndGet());
        return new ResponseEntity<>(error, HttpStatusCode.valueOf(400));
    }
}
