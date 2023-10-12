package hm.cardtransfer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorInputDataImpl extends RuntimeException {
    private String message;
    private int id;
}
