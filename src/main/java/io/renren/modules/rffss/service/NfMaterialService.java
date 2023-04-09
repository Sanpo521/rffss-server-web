package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.NfAgentEntity;
import io.renren.modules.rffss.entity.NfMaterialEntity;

import java.util.List;
import java.util.Map;

/**
 * 材料表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
public interface NfMaterialService extends IService<NfMaterialEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据业务ID查询附属信息列表
     * @param businid
     * @param mtype
     * @return
     */
    List<NfMaterialEntity> getsByBusinid(String businid, String mtype);

    /**
     * 根据业务ID查询附属信息
     * @param businid
     * @param mtype
     * @return
     */
    NfMaterialEntity getByBusinid(String businid, String mtype);


    Integer delByBusinid(String businid);
}

