package io.renren.common.validation.constraints;

import io.renren.common.validation.impl.MobileCheckImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Constraint(validatedBy = {MobileCheckImpl.class})
public @interface MobileCheck {
    //函数自己设计
    String message() default "手机号码不正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
