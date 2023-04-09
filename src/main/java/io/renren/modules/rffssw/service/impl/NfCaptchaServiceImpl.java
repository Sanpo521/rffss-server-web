package io.renren.modules.rffssw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import io.renren.common.exception.RRException;
import io.renren.common.utils.DateUtils;
import io.renren.modules.rffssw.dao.NfCaptchaDao;
import io.renren.modules.rffssw.entity.NfCaptchaEntity;
import io.renren.modules.rffssw.service.NfCaptchaService;
import io.renren.modules.sys.entity.SysCaptchaEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-01 11:27
 * @desc 外网验证码
 **/
@Service("nfCaptchaService")
public class NfCaptchaServiceImpl  extends ServiceImpl<NfCaptchaDao, NfCaptchaEntity> implements NfCaptchaService {
    @Autowired
    private Producer producer;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StringUtils.isBlank(uuid)){
            throw new RRException("uuid不能为空");
        }
        //生成文字验证码
        String code = producer.createText();

        NfCaptchaEntity captchaEntity = new NfCaptchaEntity();
        captchaEntity.setUuid(uuid);
        captchaEntity.setCode(code);
        //5分钟后过期
        captchaEntity.setExpireTime(DateUtils.addDateMinutes(new Date(), 5));
        this.save(captchaEntity);

        return producer.createImage(code);
    }

    @Override
    public boolean validate(String uuid, String code) {
        NfCaptchaEntity captchaEntity = this.getOne(new QueryWrapper<NfCaptchaEntity>().eq("uuid", uuid));
        if(captchaEntity == null){
            return false;
        }

        //删除验证码
        this.removeById(uuid);

        if(captchaEntity.getCode().equalsIgnoreCase(code) && captchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }

        return false;
    }
}
