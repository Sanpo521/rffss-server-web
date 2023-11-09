package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.AgentHistoryEntity;

import java.util.Map;

/**
 * 代理人
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
public interface AgentHistoryService extends IService<AgentHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

