package io.renren.common.validation.impl;

import io.renren.common.validation.constraints.MobileCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author zhaoxiubin
 * @create 2022-09-29 14:24
 * @desc 手机号码校验类
 **/
@Slf4j
public class MobileCheckImpl implements ConstraintValidator<MobileCheck,Object> {

    /**
     * 手机号码校验正则表达式
     */
    public final static String FORMAT_MOBILE = "^[1]([3-9])[0-9]{9}$";

    @Override
    public void initialize(MobileCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        log.debug("MobileCheck initialize");
        log.debug(constraintAnnotation.message());
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        log.debug("MobileCheck " + o.toString());
        if (!StringUtils.isEmpty(o.toString())){
            result = Pattern.compile(FORMAT_MOBILE).matcher(o.toString()).matches();
        }
        //返回false表示验证不通过
        return result;
    }
}
