package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiProvincialBureauDoubleRandomnessDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauDoubleRandomnessEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauDoubleRandomnessService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiProvincialBureauDoubleRandomnessService")
public class GyMrdipqassiProvincialBureauDoubleRandomnessServiceImpl extends ServiceImpl<GyMrdipqassiProvincialBureauDoubleRandomnessDao, GyMrdipqassiProvincialBureauDoubleRandomnessEntity> implements GyMrdipqassiProvincialBureauDoubleRandomnessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiProvincialBureauDoubleRandomnessEntity> page = this.page(
                new Query<GyMrdipqassiProvincialBureauDoubleRandomnessEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiProvincialBureauDoubleRandomnessEntity>()
        );

        return new PageUtils(page);
    }

}
