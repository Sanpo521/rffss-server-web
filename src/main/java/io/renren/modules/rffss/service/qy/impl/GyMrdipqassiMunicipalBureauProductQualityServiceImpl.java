package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiMunicipalBureauProductQualityDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiMunicipalBureauProductQualityEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiMunicipalBureauProductQualityService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiMunicipalBureauProductQualityService")
public class GyMrdipqassiMunicipalBureauProductQualityServiceImpl extends ServiceImpl<GyMrdipqassiMunicipalBureauProductQualityDao, GyMrdipqassiMunicipalBureauProductQualityEntity> implements GyMrdipqassiMunicipalBureauProductQualityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiMunicipalBureauProductQualityEntity> page = this.page(
                new Query<GyMrdipqassiMunicipalBureauProductQualityEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiMunicipalBureauProductQualityEntity>()
        );

        return new PageUtils(page);
    }

}
