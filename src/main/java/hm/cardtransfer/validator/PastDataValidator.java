package hm.cardtransfer.validator;

import hm.cardtransfer.annotations.PastData;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PastDataValidator implements ConstraintValidator<PastData, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] mounthYear = value.split("/");
        int mounth = Integer.parseInt(mounthYear[0]);
        int year = Integer.parseInt(mounthYear[1]);

        String[] dataNow = LocalDateTime.now().format (DateTimeFormatter.ofPattern("MM.yy")).split("\\.");
        int mounthNow = Integer.parseInt(dataNow[0]);
        int yearNow = Integer.parseInt(dataNow[1]);

        return mounth >= mounthNow && year >= yearNow;
    }
}
