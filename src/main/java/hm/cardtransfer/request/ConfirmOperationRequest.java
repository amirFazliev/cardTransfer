package hm.cardtransfer.request;

import lombok.Data;

@Data
public class ConfirmOperationRequest {
    private String operationId;
    private String code;
}
