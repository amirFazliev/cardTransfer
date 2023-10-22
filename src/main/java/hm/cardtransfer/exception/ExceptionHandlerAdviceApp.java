package hm.cardtransfer.exception;

import hm.cardtransfer.request.amount.Amount;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.atomic.AtomicInteger;

import static hm.cardtransfer.logger.Logger.fileLoggerAllMessageTransfer;

@RestControllerAdvice
public class ExceptionHandlerAdviceApp {
    private final AtomicInteger idException = new AtomicInteger(0);

    @ExceptionHandler(ErrorTransferImpl.class)
    public ResponseEntity<Object> authHandlerServerException(ErrorTransferImpl e, HttpServletRequest request) {
        e.setMessage("Server Exception");
        e.setId(idException.incrementAndGet());

        String cardFromNumber = request.getParameter("cardFromNumber");
        String cardToNumber = request.getParameter("cardToNumber");
        Amount amount = new Amount();
        amount.setValue(Integer.parseInt(request.getParameter("amount")));

        fileLoggerAllMessageTransfer(cardFromNumber, cardToNumber, amount, "Ошибка Server Exception");

        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorInputDataImpl.class)
    public ResponseEntity<Object> authHandlerBadRequest(ErrorInputDataImpl e, HttpServletRequest request) {
        e.setMessage("Bad Request Exception");
        e.setId(idException.incrementAndGet());

        String cardFromNumber = request.getParameter("cardFromNumber");
        String cardToNumber = request.getParameter("cardToNumber");
        Amount amount = new Amount();
        amount.setValue(Integer.parseInt(request.getParameter("amount")));

        fileLoggerAllMessageTransfer(cardFromNumber, cardToNumber, amount, "Ошибка Bad Request Exception");
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> authHandlerMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        ErrorInputDataImpl error = new ErrorInputDataImpl();
        error.setId(idException.incrementAndGet());
        error.setMessage(message);

        String cardFromNumber = request.getParameter("cardFromNumber");
        String cardToNumber = request.getParameter("cardToNumber");
        Amount amount = new Amount();
        amount.setValue(Integer.parseInt(request.getParameter("amount")));

        fileLoggerAllMessageTransfer(cardFromNumber, cardToNumber, amount, "Ошибка Bad Request Exception");

        return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
