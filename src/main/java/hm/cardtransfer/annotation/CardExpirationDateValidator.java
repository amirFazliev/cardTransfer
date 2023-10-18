package hm.cardtransfer.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardExpirationDateValidator implements ConstraintValidator<CardExpirationDate, String> {
    @Override
    public void initialize(CardExpirationDate cardExpirationDate) {
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext context) {
        if (date == null) {
            return false;
        }
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        try {
            Date expiration = dateFormat.parse(date);
            return currentDate.before(expiration);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}