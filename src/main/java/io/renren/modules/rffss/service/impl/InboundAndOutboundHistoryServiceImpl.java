package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.InboundAndOutboundHistoryDao;
import io.renren.modules.rffss.entity.InboundAndOutboundHistoryEntity;
import io.renren.modules.rffss.service.InboundAndOutboundHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("inboundAndOutboundHistoryService")
public class InboundAndOutboundHistoryServiceImpl extends ServiceImpl<InboundAndOutboundHistoryDao, InboundAndOutboundHistoryEntity> implements InboundAndOutboundHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InboundAndOutboundHistoryEntity> page = this.page(
                new Query<InboundAndOutboundHistoryEntity>().getPage(params),
                new QueryWrapper<InboundAndOutboundHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
