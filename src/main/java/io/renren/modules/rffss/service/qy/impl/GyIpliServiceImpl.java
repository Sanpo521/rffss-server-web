package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyIpliDao;
import io.renren.modules.rffss.entity.qy.GyIpliEntity;
import io.renren.modules.rffss.service.qy.GyIpliService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyIpliService")
public class GyIpliServiceImpl extends ServiceImpl<GyIpliDao, GyIpliEntity> implements GyIpliService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyIpliEntity> page = this.page(
                new Query<GyIpliEntity>().getPage(params),
                new QueryWrapper<GyIpliEntity>()
        );

        return new PageUtils(page);
    }

}
