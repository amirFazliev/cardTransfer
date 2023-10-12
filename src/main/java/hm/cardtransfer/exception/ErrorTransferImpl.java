package hm.cardtransfer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ErrorTransferImpl extends InternalError {
    private String message;
    private int id;
}
