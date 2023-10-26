package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiMunicipalBureauDoubleRandomnessService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiMunicipalBureauDoubleRandomnessService")
public class GyMrdipqassiMunicipalBureauDoubleRandomnessServiceImpl extends ServiceImpl<GyMrdipqassiMunicipalBureauDoubleRandomnessDao, GyMrdipqassiMunicipalBureauDoubleRandomnessEntity> implements GyMrdipqassiMunicipalBureauDoubleRandomnessService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiMunicipalBureauDoubleRandomnessEntity> page = this.page(
                new Query<GyMrdipqassiMunicipalBureauDoubleRandomnessEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

}
