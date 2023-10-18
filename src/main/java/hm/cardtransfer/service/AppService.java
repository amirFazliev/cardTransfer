package hm.cardtransfer.service;

import hm.cardtransfer.repository.AppRepository;
import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppService {
    @Autowired
    private AppRepository appRepository;

    public TransferResponce transferMoneyCardToCard(TransferRequest transferRequest) {
        TransferResponce responce = appRepository.transferMoneyCardToCard(transferRequest);
        return responce;
    }

    public ConfirmOperationResponce confirmOperation(ConfirmOperationRequest confirmOperationRequest) {
        ConfirmOperationResponce confirmOperationResponce = appRepository.confirmOperation(confirmOperationRequest);
        return confirmOperationResponce;
    }
}
