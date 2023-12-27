package io.renren.modules.rffss.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.ThirdColdStorageInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * oracle保存
 * @author zzb
 */
public interface ThirdColdStorageInfoService extends IService<ThirdColdStorageInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveData(ThirdColdStorageInfoEntity thirdColdStorageInfo);

    List<Map<String,Object>> selectUnb();
}

