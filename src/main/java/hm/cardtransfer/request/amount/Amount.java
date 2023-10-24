package hm.cardtransfer.request.amount;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
