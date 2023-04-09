package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.NfRffsspUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 外网用户与主体关联表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
public interface NfRffsspUserService extends IService<NfRffsspUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<NfRffsspUserEntity> getByUserid(Long userid);

    List<NfRffsspUserEntity> getByRffssid(String rffssid);

    NfRffsspUserEntity getByRffssidAndUserid(String rffssid, Long userid);
}

