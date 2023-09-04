package hm.cardtransfer.validator;

import hm.cardtransfer.annotations.PastData;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PastDataValidator implements ConstraintValidator<PastData, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int mounth = Integer.parseInt(value.substring(0, 2));
        int year = Integer.parseInt(value.substring(2));

        String[] dataNow = LocalDateTime.now().format (DateTimeFormatter.ofPattern("MM.yy")).split("\\.");
        int mounthNow = Integer.parseInt(dataNow[0]);
        int yearNow = Integer.parseInt(dataNow[1]);

        return mounth >= mounthNow && year >= yearNow;
    }
}
