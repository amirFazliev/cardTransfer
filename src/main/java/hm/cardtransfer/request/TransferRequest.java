package hm.cardtransfer.request;

import hm.cardtransfer.annotation.CardExpirationDate;
import hm.cardtransfer.request.amount.Amount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    @NotBlank (message = "Номер карты отправителя обязателен")
    @Size(min = 16, max = 16, message = "Номер карты отправителя должен быть 16 символов")
    private String cardFromNumber;

    @NotBlank (message = "Номер карты получателя обязателен")
    @Size(min = 16, max = 16, message = "Номер карты получателя должен быть 16 символов")
    private String cardToNumber;

    @NotBlank (message = "CVC / CVC2 номер карты отправителя обязателен")
    @Size(min = 3, max = 3, message = "CVC / CVC2 код отправителя должен состоять из 3 символов")
    private String cardFromCVV;

    @NotBlank (message = "Срок действия карты отправителя обязателен") // когда ничего нет
    @Size(min = 5, max = 5, message = "Месяц действия карты обязателен и должен состоять из 2 цифр") // когда 1,2 или 3 цифры указано
    @CardExpirationDate // Истекла дата действия карты отправителя
    private String  cardFromValidTill;


    private Amount amount;
}
