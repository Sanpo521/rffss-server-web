package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.BusinHistoryEntity;

import java.util.Map;

/**
 * 业务表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
public interface BusinHistoryService extends IService<BusinHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

