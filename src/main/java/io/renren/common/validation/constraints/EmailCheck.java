package io.renren.common.validation.constraints;

import io.renren.common.validation.impl.EmailCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Constraint(validatedBy = {EmailCheckImpl.class})
public @interface EmailCheck {
    //函数自己设计
    String message() default "电子邮箱不正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
