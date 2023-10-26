package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiProvincialBureauProductQualityDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiProvincialBureauProductQualityEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiProvincialBureauProductQualityService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiProvincialBureauProductQualityService")
public class GyMrdipqassiProvincialBureauProductQualityServiceImpl extends ServiceImpl<GyMrdipqassiProvincialBureauProductQualityDao, GyMrdipqassiProvincialBureauProductQualityEntity> implements GyMrdipqassiProvincialBureauProductQualityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiProvincialBureauProductQualityEntity> page = this.page(
                new Query<GyMrdipqassiProvincialBureauProductQualityEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiProvincialBureauProductQualityEntity>()
        );

        return new PageUtils(page);
    }

}
