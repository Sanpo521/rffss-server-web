package io.renren.modules.rffssw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-01 11:11
 * @desc 外网系统验证码
 **/
@Data
@TableName("nf_wcaptcha")
public class NfCaptchaEntity {
    @TableId(type = IdType.INPUT)
    private String uuid;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间
     */
    private Date expireTime;
}
