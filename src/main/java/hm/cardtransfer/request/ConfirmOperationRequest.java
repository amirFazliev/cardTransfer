package hm.cardtransfer.request;

import java.util.Objects;

public class ConfirmOperationRequest {
    private String operationId;
    private String code;

    public ConfirmOperationRequest(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public ConfirmOperationRequest() {
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ConfirmOperationRequest{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmOperationRequest that = (ConfirmOperationRequest) o;
        return Objects.equals(operationId, that.operationId) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, code);
    }
}
