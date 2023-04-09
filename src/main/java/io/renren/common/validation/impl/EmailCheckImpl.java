package io.renren.common.validation.impl;

import io.renren.common.validation.constraints.EmailCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author zhaoxiubin
 * @create 2022-09-29 14:35
 * @desc 电子邮箱校验实现类
 **/

@Slf4j
public class EmailCheckImpl implements ConstraintValidator<EmailCheck,Object> {
    /**
     * 电子邮箱校验正则表达式
     */
    public final static String FORMAT_EMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";

    @Override
    public void initialize(EmailCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        log.debug("EmailCheck initialize");
        log.debug(constraintAnnotation.message());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        log.debug("EmailCheck " + o.toString());
        if (!StringUtils.isEmpty(o.toString())){
            result = Pattern.compile(FORMAT_EMAIL).matcher(o.toString()).matches();
        }
        //返回false表示验证不通过
        return result;
    }
}
