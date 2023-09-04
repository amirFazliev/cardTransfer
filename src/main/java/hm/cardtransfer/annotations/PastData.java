package hm.cardtransfer.annotations;

import hm.cardtransfer.validator.PastDataValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= PastDataValidator.class)
public @interface PastData {
    String message() default "Истекла дата действия карты отправителя";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
