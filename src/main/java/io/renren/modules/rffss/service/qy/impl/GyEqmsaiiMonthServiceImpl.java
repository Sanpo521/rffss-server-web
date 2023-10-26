package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyEqmsaiiMonthDao;
import io.renren.modules.rffss.entity.qy.GyEqmsaiiMonthEntity;
import io.renren.modules.rffss.service.qy.GyEqmsaiiMonthService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyEqmsaiiMonthService")
public class GyEqmsaiiMonthServiceImpl extends ServiceImpl<GyEqmsaiiMonthDao, GyEqmsaiiMonthEntity> implements GyEqmsaiiMonthService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyEqmsaiiMonthEntity> page = this.page(
                new Query<GyEqmsaiiMonthEntity>().getPage(params),
                new QueryWrapper<GyEqmsaiiMonthEntity>()
        );

        return new PageUtils(page);
    }

}
