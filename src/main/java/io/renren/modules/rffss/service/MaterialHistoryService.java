package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.MaterialHistoryEntity;

import java.util.Map;

/**
 * 材料表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
public interface MaterialHistoryService extends IService<MaterialHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

