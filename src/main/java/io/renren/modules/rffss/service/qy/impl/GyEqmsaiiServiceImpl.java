package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyEqmsaiiDao;
import io.renren.modules.rffss.entity.qy.GyEqmsaiiEntity;
import io.renren.modules.rffss.service.qy.GyEqmsaiiService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyEqmsaiiService")
public class GyEqmsaiiServiceImpl extends ServiceImpl<GyEqmsaiiDao, GyEqmsaiiEntity> implements GyEqmsaiiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyEqmsaiiEntity> page = this.page(
                new Query<GyEqmsaiiEntity>().getPage(params),
                new QueryWrapper<GyEqmsaiiEntity>()
        );

        return new PageUtils(page);
    }

}
