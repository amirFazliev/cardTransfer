package hm.cardtransfer.annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CardExpirationDateValidator.class)
public @interface CardExpirationDate {
    String message() default "Истекла дата действия карты отправителя";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
