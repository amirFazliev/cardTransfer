package hm.cardtransfer.service;

import hm.cardtransfer.repository.AppRepository;
import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.ResponceError;
import hm.cardtransfer.responce.TransferResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static hm.cardtransfer.logger.Logger.fileLoggerAllMessageConfirmOperation;
import static hm.cardtransfer.logger.Logger.fileLoggerAllMessageTransfer;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public TransferResponce transferMoneyCardToCard(TransferRequest transferRequest) {
        try {
            System.out.println("Hello from AppService - transfer");
            TransferResponce responce = appRepository.transferMoneyCardToCard(transferRequest);
            fileLoggerAllMessageTransfer(transferRequest.getCardFromNumber(), transferRequest.getCardToNumber(), transferRequest.getAmount(), "OK");
            return responce;
        } catch (ResponceError e) {
            fileLoggerAllMessageTransfer(transferRequest.getCardFromNumber(), transferRequest.getCardToNumber(), transferRequest.getAmount(), "Ошибка сервера Error transfer");
            throw new ResponceError("Ошибка сервера - Error transfer");
        }

    }

    public ConfirmOperationResponce confirmOperation (ConfirmOperationRequest confirmOperationRequest) {
        try {
            System.out.println("Hello from AppService - confirmOperation");
            ConfirmOperationResponce confirmOperationResponce = appRepository.confirmOperation(confirmOperationRequest);
            fileLoggerAllMessageConfirmOperation(confirmOperationRequest.getOperationId(), confirmOperationRequest.getCode(), "OK");
            return confirmOperationResponce;
        } catch (ResponceError e) {
            fileLoggerAllMessageConfirmOperation(confirmOperationRequest.getOperationId(), confirmOperationRequest.getCode(), "Ошибка сервера - Error confirmOperation");
            throw new ResponceError("Ошибка сервера - Error confirmOperation");
        }

    }
}
