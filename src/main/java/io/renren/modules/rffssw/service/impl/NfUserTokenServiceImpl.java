package io.renren.modules.rffssw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.R;
import io.renren.modules.rffssw.dao.NfUserTokenDao;
import io.renren.modules.rffssw.entity.NfUserTokenEntity;
import io.renren.modules.rffssw.service.NfUserTokenService;
import io.renren.modules.sys.oauth2.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-11-01 11:29
 * @desc 外网用户Token服务实现类
 **/
@Service("nfUserTokenService")
public class NfUserTokenServiceImpl  extends ServiceImpl<NfUserTokenDao, NfUserTokenEntity> implements NfUserTokenService {
    //0.5小时后过期
    private final static int EXPIRE = 1800;


    @Override
    public R createToken(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        NfUserTokenEntity tokenEntity = this.getById(userId);
        if(tokenEntity == null){
            tokenEntity = new NfUserTokenEntity();
            tokenEntity.setId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }

        R r = R.ok().put("token", token).put("expire", EXPIRE);

        return r;
    }

    @Override
    public void logout(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        NfUserTokenEntity tokenEntity = new NfUserTokenEntity();
        tokenEntity.setId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }
}
