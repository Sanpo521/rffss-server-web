package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyEpiDao;
import io.renren.modules.rffss.entity.qy.GyEpiEntity;
import io.renren.modules.rffss.service.qy.GyEpiService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyEpiService")
public class GyEpiServiceImpl extends ServiceImpl<GyEpiDao, GyEpiEntity> implements GyEpiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyEpiEntity> page = this.page(
                new Query<GyEpiEntity>().getPage(params),
                new QueryWrapper<GyEpiEntity>()
        );

        return new PageUtils(page);
    }

}
