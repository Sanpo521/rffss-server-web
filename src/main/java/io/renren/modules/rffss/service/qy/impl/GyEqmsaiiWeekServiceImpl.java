package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyEqmsaiiWeekDao;
import io.renren.modules.rffss.entity.qy.GyEqmsaiiWeekEntity;
import io.renren.modules.rffss.service.qy.GyEqmsaiiWeekService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyEqmsaiiWeekService")
public class GyEqmsaiiWeekServiceImpl extends ServiceImpl<GyEqmsaiiWeekDao, GyEqmsaiiWeekEntity> implements GyEqmsaiiWeekService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyEqmsaiiWeekEntity> page = this.page(
                new Query<GyEqmsaiiWeekEntity>().getPage(params),
                new QueryWrapper<GyEqmsaiiWeekEntity>()
        );

        return new PageUtils(page);
    }

}
