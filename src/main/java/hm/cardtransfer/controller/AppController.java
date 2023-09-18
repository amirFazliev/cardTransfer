package hm.cardtransfer.controller;

import hm.cardtransfer.annotations.AppAnnotationConfirmOperationRequest;
import hm.cardtransfer.annotations.AppAnnotationTransferRequest;
import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import hm.cardtransfer.service.AppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class AppController {
    @Autowired
    private AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/transfer")
    @ResponseBody
    public TransferResponce transferMoneyCardToCard (@AppAnnotationTransferRequest @RequestBody @Validated TransferRequest transferRequest) {
        System.out.println("Hello from AppController - transfer");
        return appService.transferMoneyCardToCard(transferRequest);
    }

    @PostMapping("/confirmOperation")
    @ResponseBody
    public ConfirmOperationResponce confirmOperation (@AppAnnotationConfirmOperationRequest @RequestBody @Validated ConfirmOperationRequest confirmOperationRequest) {
        System.out.println("Hello from AppController - confirmOperation");
        return appService.confirmOperation(confirmOperationRequest);
    }
}
