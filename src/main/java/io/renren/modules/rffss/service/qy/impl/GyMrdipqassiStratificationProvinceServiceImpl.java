package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiStratificationProvinceDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationProvinceEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiStratificationProvinceService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiStratificationProvinceService")
public class GyMrdipqassiStratificationProvinceServiceImpl extends ServiceImpl<GyMrdipqassiStratificationProvinceDao, GyMrdipqassiStratificationProvinceEntity> implements GyMrdipqassiStratificationProvinceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiStratificationProvinceEntity> page = this.page(
                new Query<GyMrdipqassiStratificationProvinceEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiStratificationProvinceEntity>()
        );

        return new PageUtils(page);
    }

}
