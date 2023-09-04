package hm.cardtransfer.service;

import hm.cardtransfer.repository.AppRepository;
import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    public AppService(AppRepository appRepository) {
        this.appRepository = appRepository;
    }


    public TransferResponce transferMoneyCardToCard(TransferRequest transferRequest) {
        System.out.println("Hello from AppService - transfer");
        return appRepository.transferMoneyCardToCard(transferRequest);
    }

    public ConfirmOperationResponce confirmOperation (ConfirmOperationRequest confirmOperationRequest) {
        System.out.println("Hello from AppService - confirmOperation");
        return appRepository.confirmOperation(confirmOperationRequest);
    }
}
