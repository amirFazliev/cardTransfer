package hm.cardtransfer.responce;

import java.util.Objects;

public class ResponceError extends InternalError {

    private String message;

    private int id;


    public ResponceError(String message1) {
        super(message1);
    }

    public ResponceError(String message, int id) {
        this.id = id;
        this.message = message;
        throw new ResponceError(message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponceError that = (ResponceError) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
