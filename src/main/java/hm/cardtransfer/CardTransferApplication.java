package hm.cardtransfer;

import hm.cardtransfer.responce.amount.Amount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class CardTransferApplication {
    private static final File fileLogTransferInfo = new File("fileLogTransferInfo.log");

    public static void main(String[] args) {
        SpringApplication.run(CardTransferApplication.class, args);
    }

    public static void fileLoggerAllMessage(String cardFromNumber, String cardToNumber, Amount amount, String textResult) {
        try (FileOutputStream fos = new FileOutputStream(fileLogTransferInfo, true)) {
            byte[] bytes = (logForm(cardFromNumber, cardToNumber, amount) + textResult + "]\n").getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String logForm (String cardFromNumber, String cardToNumber, Amount amount) {

        return "[" + LocalDateTime.now().format (DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"))
                + ", карта списания - " + cardFromNumber
                + ", карта зачисления - " + cardToNumber
                + ", сумма - " + amount.getValue()
                + ", комиссия - " + amount.getValue()*0.01
                + ", результат операции, если был - ";
    }
}
