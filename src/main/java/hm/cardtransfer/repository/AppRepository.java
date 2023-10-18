package hm.cardtransfer.repository;

import hm.cardtransfer.request.ConfirmOperationRequest;
import hm.cardtransfer.request.TransferRequest;
import hm.cardtransfer.responce.ConfirmOperationResponce;
import hm.cardtransfer.responce.TransferResponce;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class AppRepository {

    private TransferResponce transferResponce = new TransferResponce();

    private ConfirmOperationResponce confirmOperationResponce = new ConfirmOperationResponce();

    private final AtomicInteger idRequest = new AtomicInteger(0);

    private ConcurrentHashMap<Integer, TransferRequest> mapRepo = new ConcurrentHashMap<>();

    public TransferResponce transferMoneyCardToCard(TransferRequest request) {
        mapRepo.put(idRequest.incrementAndGet(), request);
        transferResponce.setOperationId("operationTransferResponce" + request.hashCode());
        return transferResponce;
    }

    public ConfirmOperationResponce confirmOperation(ConfirmOperationRequest request) {
        confirmOperationResponce.setOperationId("confirmOperationResponce" + request.hashCode());
        return confirmOperationResponce;
    }


}
