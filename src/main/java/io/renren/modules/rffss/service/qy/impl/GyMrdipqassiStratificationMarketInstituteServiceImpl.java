package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiStratificationMarketInstituteDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiStratificationMarketInstituteEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiStratificationMarketInstituteService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiStratificationMarketInstituteService")
public class GyMrdipqassiStratificationMarketInstituteServiceImpl extends ServiceImpl<GyMrdipqassiStratificationMarketInstituteDao, GyMrdipqassiStratificationMarketInstituteEntity> implements GyMrdipqassiStratificationMarketInstituteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiStratificationMarketInstituteEntity> page = this.page(
                new Query<GyMrdipqassiStratificationMarketInstituteEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiStratificationMarketInstituteEntity>()
        );

        return new PageUtils(page);
    }

}
