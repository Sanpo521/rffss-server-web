package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.RffsspHistoryEntity;

import java.util.Map;

/**
 * 冷藏冷冻食品贮存服务提供者
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
public interface RffsspHistoryService extends IService<RffsspHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

