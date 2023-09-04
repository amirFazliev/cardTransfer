package hm.cardtransfer.request;

import hm.cardtransfer.responce.amount.Amount;
import hm.cardtransfer.annotations.MounthTwelve;
import hm.cardtransfer.annotations.PastData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;


public class TransferRequest {
    @NotBlank (message = "Номер карты отправителя обязателен")
    @Size(min = 12, max = 12, message = "Номер карты отправителя должен быть 16 символов")
    private String cardFromNumber;

    @NotBlank (message = "Срок действия карты отправителя обязателен") // когда ничего нет
    @Size(min = 4, max = 4, message = "Месяц действия карты обязателен и должен состоять из 2 цифр") // когда 1,2 или 3 цифры указано
    @MounthTwelve //запрет на большой месяц - Текущий месяц не может быть больше 12
    @PastData // запрет на истекшие даты - Истекла дата действия карты отправителя
    private String  cardFromValidTill;

    @NotBlank (message = "CVC / CVC2 номер карты отправителя обязателен")
    @Size(min = 3, max = 3, message = "CVC / CVC2 код отправителя должен состоять из 3 символов")
    private String cardFromCVV;

    @NotBlank (message = "Номер карты получателя обязателен")
    @Size(min = 12, max = 12, message = "Номер карты получателя должен быть 16 символов")
    private String cardToNumber;

    private Amount amount;

    public TransferRequest(String cardFromNumber,
                           String cardFromValidTill,
                           String cardFromCVV,
                           String cardToNumber,
                           Amount amount) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public void setCardFromNumber(String cardFromNumber) {
        this.cardFromNumber = cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public void setCardFromValidTill(String cardFromValidTill) {
        this.cardFromValidTill = cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public void setCardFromCVV(String cardFromCVV) {
        this.cardFromCVV = cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public void setCardToNumber(String cardToNumber) {
        this.cardToNumber = cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferRequest that = (TransferRequest) o;
        return Objects.equals(cardFromNumber, that.cardFromNumber) && Objects.equals(cardFromValidTill, that.cardFromValidTill) && Objects.equals(cardFromCVV, that.cardFromCVV) && Objects.equals(cardToNumber, that.cardToNumber) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFromNumber, cardFromValidTill, cardFromCVV, cardToNumber, amount);
    }
}
