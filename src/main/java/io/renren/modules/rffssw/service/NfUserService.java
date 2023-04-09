package io.renren.modules.rffssw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.sys.entity.SysUserEntity;

public interface NfUserService extends IService<NfUserEntity> {
    /**
     * 根据用户名，查询系统用户
     */
    NfUserEntity queryByUserName(String username);

    /**
     * 保存用户
     */
    void saveUser(NfUserEntity user);

    /**
     * 修改用户
     */
    void update(NfUserEntity user);

    /**
     * 删除用户
     */
    void delete(Long id);

    /**
     * 修改密码
     * @param id       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    boolean updatePassword(Long id, String password, String newPassword);
}
