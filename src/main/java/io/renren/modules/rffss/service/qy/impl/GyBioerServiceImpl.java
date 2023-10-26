package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyBioerDao;
import io.renren.modules.rffss.entity.qy.GyBioerEntity;
import io.renren.modules.rffss.service.qy.GyBioerService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyBioerService")
public class GyBioerServiceImpl extends ServiceImpl<GyBioerDao, GyBioerEntity> implements GyBioerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyBioerEntity> page = this.page(
                new Query<GyBioerEntity>().getPage(params),
                new QueryWrapper<GyBioerEntity>()
        );

        return new PageUtils(page);
    }

}
