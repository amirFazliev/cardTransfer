package hm.cardtransfer.logger;

import hm.cardtransfer.request.amount.Amount;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static hm.cardtransfer.CardTransferApplication.fileLogTransferInfo;

public class Logger {

    public static void fileLoggerAllMessageTransfer(String cardFromNumber, String cardToNumber, Amount amount, String textResult) {
        try (FileOutputStream fos = new FileOutputStream(fileLogTransferInfo, true)) {
            byte[] bytes = ("[" + "Transfer money card to card - " + logFormTransfer(cardFromNumber, cardToNumber, amount) + textResult + "]\n").getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fileLoggerAllMessageConfirmOperation(String operationId, String code, String textResult) {
        try (FileOutputStream fos = new FileOutputStream(fileLogTransferInfo, true)) {
            byte[] bytes = ("[" + "Confirm operation - " + logFormConfirmOperation(operationId, code) + textResult + "]\n").getBytes();
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String logFormTransfer (String cardFromNumber, String cardToNumber, Amount amount) {

        return "[" + LocalDateTime.now().format (DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"))
                + ", карта списания - " + cardFromNumber
                + ", карта зачисления - " + cardToNumber
                + ", сумма - " + amount.getValue()
                + ", комиссия - " + amount.getValue()*0.01
                + ", результат операции, если был - ";
    }

    private static String logFormConfirmOperation (String operationId, String code) {

        return "[" + LocalDateTime.now().format (DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss"))
                + ", Id операции - " + operationId
                + ", код верификации - " + code
                + ", результат операции, если был - ";
    }
}
