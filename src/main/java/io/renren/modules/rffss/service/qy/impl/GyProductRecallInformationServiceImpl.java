package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyProductRecallInformationDao;
import io.renren.modules.rffss.entity.qy.GyProductRecallInformationEntity;
import io.renren.modules.rffss.service.qy.GyProductRecallInformationService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyProductRecallInformationService")
public class GyProductRecallInformationServiceImpl extends ServiceImpl<GyProductRecallInformationDao, GyProductRecallInformationEntity> implements GyProductRecallInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyProductRecallInformationEntity> page = this.page(
                new Query<GyProductRecallInformationEntity>().getPage(params),
                new QueryWrapper<GyProductRecallInformationEntity>()
        );

        return new PageUtils(page);
    }

}
