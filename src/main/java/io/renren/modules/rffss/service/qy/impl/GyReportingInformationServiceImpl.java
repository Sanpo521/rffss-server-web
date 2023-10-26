package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyReportingInformationDao;
import io.renren.modules.rffss.entity.qy.GyReportingInformationEntity;
import io.renren.modules.rffss.service.qy.GyReportingInformationService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyReportingInformationService")
public class GyReportingInformationServiceImpl extends ServiceImpl<GyReportingInformationDao, GyReportingInformationEntity> implements GyReportingInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyReportingInformationEntity> page = this.page(
                new Query<GyReportingInformationEntity>().getPage(params),
                new QueryWrapper<GyReportingInformationEntity>()
        );

        return new PageUtils(page);
    }

}
