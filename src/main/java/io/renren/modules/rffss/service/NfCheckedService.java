package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.NfCheckedEntity;
import io.renren.modules.rffss.entity.NfMaterialEntity;

import java.util.Map;

/**
 * 操作记录
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
public interface NfCheckedService extends IService<NfCheckedEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据业务ID查询受理审核信息
     * @param businid
     * @param ctype
     * @return
     */
    NfCheckedEntity getByBusinid(String businid, String ctype);

    Integer delByBusinid(String businid);
}

