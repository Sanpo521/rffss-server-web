package io.renren.modules.rffssw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.rffssw.dao.NfUserDao;
import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.rffssw.service.NfUserService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * @author zhaoxiubin
 * @create 2022-10-31 15:32
 * @desc 外网用户实现类
 **/

@Service("nfUserService")
public class NfUserServiceImpl extends ServiceImpl<NfUserDao, NfUserEntity> implements NfUserService {

    @Override
    public NfUserEntity queryByUserName(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public void saveUser(NfUserEntity user) {
        user.setCreatetime(new Date());
        user.setStatus(1);
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
        user.setSalt(salt);
        this.save(user);
    }

    @Override
    public void update(NfUserEntity user) {
        user.setStatus(1);
        if(StringUtils.isBlank(user.getPassword())){
            user.setPassword(null);
        }else{
            user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
        }
        this.updateById(user);
    }

    @Override
    public void delete(Long id) {
        NfUserEntity userEntity = new NfUserEntity();
        userEntity.setStatus(0);
        this.update(userEntity, new QueryWrapper<NfUserEntity>().eq("id", id));
    }

    @Override
    public boolean updatePassword(Long id, String password, String newPassword) {
        NfUserEntity userEntity = new NfUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new QueryWrapper<NfUserEntity>().eq("id", id).eq("password", password));
    }
}
