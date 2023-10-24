package hm.cardtransfer.controller;

import hm.cardtransfer.exception.ErrorInputDataImpl;
import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import hm.cardtransfer.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
@RequiredArgsConstructor
public class AppController {
    @Autowired
    private final AppService appService;

    @PostMapping("/transfer")
    public TransferResponce transferMoneyCardToCard (@RequestBody @Validated TransferRequest transferRequest) {
        return appService.transferMoneyCardToCard(transferRequest);
    }

    @PostMapping("/confirmOperation")
    public ConfirmOperationResponce confirmOperation (@RequestBody @Validated ConfirmOperationRequest confirmOperationRequest) {
        return appService.confirmOperation(confirmOperationRequest);
    }
}
