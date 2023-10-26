package io.renren.modules.rffss.service.qy;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessEntity;

import java.util.Map;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-24 09:44:37
 */
public interface GyMrdipqassiMunicipalBureauDoubleRandomnessService extends IService<GyMrdipqassiMunicipalBureauDoubleRandomnessEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

