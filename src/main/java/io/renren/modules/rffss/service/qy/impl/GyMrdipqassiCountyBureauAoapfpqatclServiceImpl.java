package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiCountyBureauAoapfpqatclDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauAoapfpqatclEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauAoapfpqatclService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiCountyBureauAoapfpqatclService")
public class GyMrdipqassiCountyBureauAoapfpqatclServiceImpl extends ServiceImpl<GyMrdipqassiCountyBureauAoapfpqatclDao, GyMrdipqassiCountyBureauAoapfpqatclEntity> implements GyMrdipqassiCountyBureauAoapfpqatclService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiCountyBureauAoapfpqatclEntity> page = this.page(
                new Query<GyMrdipqassiCountyBureauAoapfpqatclEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiCountyBureauAoapfpqatclEntity>()
        );

        return new PageUtils(page);
    }

}
