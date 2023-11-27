package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.CheckedHistoryEntity;

import java.util.Map;

/**
 * 操作记录
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
public interface CheckedHistoryService extends IService<CheckedHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
