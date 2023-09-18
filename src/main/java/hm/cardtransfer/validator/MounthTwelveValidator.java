package hm.cardtransfer.validator;

import hm.cardtransfer.annotations.MounthTwelve;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class MounthTwelveValidator implements ConstraintValidator<MounthTwelve, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int mounth = Integer.parseInt(value.substring(0, 2));

        return mounth > 0 && mounth <= 12;
    }
}
