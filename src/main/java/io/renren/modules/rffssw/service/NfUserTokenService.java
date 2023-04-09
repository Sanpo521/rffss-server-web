package io.renren.modules.rffssw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.rffssw.entity.NfUserTokenEntity;

public interface NfUserTokenService  extends IService<NfUserTokenEntity> {

    /**
     * 生成token
     * @param id  用户ID
     */
    R createToken(long id);

    /**
     * 退出，修改token值
     * @param id  用户ID
     */
    void logout(long id);
}
