package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyMarketRegulatedInformationDao;
import io.renren.modules.rffss.entity.qy.GyMarketRegulatedInformationEntity;
import io.renren.modules.rffss.service.qy.GyMarketRegulatedInformationService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyMarketRegulatedInformationService")
public class GyMarketRegulatedInformationServiceImpl extends ServiceImpl<GyMarketRegulatedInformationDao, GyMarketRegulatedInformationEntity> implements GyMarketRegulatedInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyMarketRegulatedInformationEntity> page = this.page(
                new Query<GyMarketRegulatedInformationEntity>().getPage(params),
                new QueryWrapper<GyMarketRegulatedInformationEntity>()
        );

        return new PageUtils(page);
    }

}
