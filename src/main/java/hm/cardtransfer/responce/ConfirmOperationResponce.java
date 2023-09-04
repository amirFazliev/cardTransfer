package hm.cardtransfer.responce;

import java.util.Objects;

public class ConfirmOperationResponce {
    private String operationId;

    public ConfirmOperationResponce() {
    }

    public ConfirmOperationResponce(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmOperationResponce that = (ConfirmOperationResponce) o;
        return Objects.equals(operationId, that.operationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId);
    }

    @Override
    public String toString() {
        return "ConfirmOperationResponce{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
