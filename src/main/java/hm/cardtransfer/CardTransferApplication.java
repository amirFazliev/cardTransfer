package hm.cardtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class CardTransferApplication {
    public static final File fileLogTransferInfo = new File("fileLogTransferInfo.log");

    public static void main(String[] args) {
        SpringApplication.run(CardTransferApplication.class, args);
    }


}
