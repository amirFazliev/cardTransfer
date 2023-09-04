package hm.cardtransfer.repository;

import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import org.springframework.stereotype.Repository;


@Repository
public class AppRepository {

    private TransferResponce transferResponce = new TransferResponce();

    private ConfirmOperationResponce confirmOperationResponce = new ConfirmOperationResponce();

    public TransferResponce transferMoneyCardToCard (TransferRequest request) {
        transferResponce.setOperationId("operationTransferResponce" + request.hashCode());
        System.out.println("Hello from AppRepository - transfer");
        return transferResponce;
    }

    public ConfirmOperationResponce confirmOperation (ConfirmOperationRequest request) {
        confirmOperationResponce.setOperationId("operationTransferResponce" + request.hashCode());
        System.out.println("Hello from AppRepository - confirmOperation");
        return confirmOperationResponce;
    }


}
