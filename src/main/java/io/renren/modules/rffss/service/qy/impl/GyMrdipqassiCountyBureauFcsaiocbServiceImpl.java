package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMrdipqassiCountyBureauFcsaiocbDao;
import io.renren.modules.rffss.entity.qy.GyMrdipqassiCountyBureauFcsaiocbEntity;
import io.renren.modules.rffss.service.qy.GyMrdipqassiCountyBureauFcsaiocbService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMrdipqassiCountyBureauFcsaiocbService")
public class GyMrdipqassiCountyBureauFcsaiocbServiceImpl extends ServiceImpl<GyMrdipqassiCountyBureauFcsaiocbDao, GyMrdipqassiCountyBureauFcsaiocbEntity> implements GyMrdipqassiCountyBureauFcsaiocbService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMrdipqassiCountyBureauFcsaiocbEntity> page = this.page(
                new Query<GyMrdipqassiCountyBureauFcsaiocbEntity>().getPage(params),
                new QueryWrapper<GyMrdipqassiCountyBureauFcsaiocbEntity>()
        );

        return new PageUtils(page);
    }

}
