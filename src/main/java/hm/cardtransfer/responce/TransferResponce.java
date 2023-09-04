package hm.cardtransfer.responce;

import java.util.Objects;

public class TransferResponce {
    private String operationId;

    public TransferResponce() {
    }

    public TransferResponce(String operationId) {
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
        TransferResponce that = (TransferResponce) o;
        return Objects.equals(operationId, that.operationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId);
    }

    @Override
    public String toString() {
        return "TransferResponce{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
