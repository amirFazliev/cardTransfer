package hm.cardtransfer.request.amount;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Amount {
    private final String currency = "RUR";
    @NotBlank
    @Min(1)
    private Integer value;

    @Override
    public String toString() {
        return "" + value;
    }
}
