package hm.cardtransfer.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestControllerAdvice
public class ExceptionHandlerAdviceApp {
    private final AtomicInteger idException = new AtomicInteger(0);

    @ExceptionHandler(ErrorTransferImpl.class)
    public ResponseEntity<Object> authHandlerServerException(ErrorTransferImpl e) {
        e.setMessage("Server Exception");
        e.setId(idException.incrementAndGet());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatusCode.valueOf(500));
    }

    @ExceptionHandler(ErrorInputDataImpl.class)
    public ResponseEntity<Object> authHandlerBadRequest(ErrorInputDataImpl e) {
        e.setMessage("Bad Request Exception");
        e.setId(idException.incrementAndGet());
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> authHandlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorInputDataImpl error = new ErrorInputDataImpl();
        error.setId(idException.incrementAndGet());
        error.setMessage(message);
        return new ResponseEntity<>(error.getMessage(), HttpStatusCode.valueOf(400));
    }
}
