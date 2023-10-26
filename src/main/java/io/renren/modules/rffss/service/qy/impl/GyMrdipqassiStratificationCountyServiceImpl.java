package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiStratificationCountyDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationCountyEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiStratificationCountyService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiStratificationCountyService")
public class GyMrdipqassiStratificationCountyServiceImpl extends ServiceImpl<GyMrdipqassiStratificationCountyDao, GyMrdipqassiStratificationCountyEntity> implements GyMrdipqassiStratificationCountyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiStratificationCountyEntity> page = this.page(
                new Query<GyMrdipqassiStratificationCountyEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiStratificationCountyEntity>()
        );

        return new PageUtils(page);
    }

}
