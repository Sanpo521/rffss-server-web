package io.renren.modules.rffss.service.qy;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationCountyEntity;

import java.util.Map;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:40
 */
public interface GyMrdipqassiStratificationCountyService extends IService<GyMrdipqassiStratificationCountyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

