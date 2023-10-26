package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiCountyBureauClpqsascDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauClpqsascEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauClpqsascService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiCountyBureauClpqsascService")
public class GyMrdipqassiCountyBureauClpqsascServiceImpl extends ServiceImpl<GyMrdipqassiCountyBureauClpqsascDao, GyMrdipqassiCountyBureauClpqsascEntity> implements GyMrdipqassiCountyBureauClpqsascService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiCountyBureauClpqsascEntity> page = this.page(
                new Query<GyMrdipqassiCountyBureauClpqsascEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiCountyBureauClpqsascEntity>()
        );

        return new PageUtils(page);
    }

}
