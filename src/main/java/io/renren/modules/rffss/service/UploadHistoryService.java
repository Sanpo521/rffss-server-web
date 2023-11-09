package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.UploadHistoryEntity;

import java.util.Map;

/**
 * 
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:16
 */
public interface UploadHistoryService extends IService<UploadHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

