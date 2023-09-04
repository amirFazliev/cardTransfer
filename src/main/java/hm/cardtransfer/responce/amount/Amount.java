package hm.cardtransfer.responce.amount;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Amount {
    private final String currency = "RUR";

    @NotBlank
    @Min(1)
    private Integer value;

    public Amount(Integer value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getValue() {
        return value;
    }

}
