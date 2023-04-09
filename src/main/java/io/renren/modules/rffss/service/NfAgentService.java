package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.NfAgentEntity;

import java.util.Map;

/**
 * 代理人
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
public interface NfAgentService extends IService<NfAgentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据业务ID查询代理人信息
     * @param businid
     * @return
     */
    NfAgentEntity getByBusinid(String businid);

    Integer delByBusinid(String businid);
}

