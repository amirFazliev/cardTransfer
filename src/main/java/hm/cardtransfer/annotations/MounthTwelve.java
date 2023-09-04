package hm.cardtransfer.annotations;

import hm.cardtransfer.validator.MounthTwelveValidator;
import hm.cardtransfer.validator.PastDataValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= MounthTwelveValidator.class)
public @interface MounthTwelve {
    String message() default "Текущий месяц не может быть больше 12";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
