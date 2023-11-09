package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.AgentHistoryDao;
import io.renren.modules.rffss.entity.AgentHistoryEntity;
import io.renren.modules.rffss.service.AgentHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("agentHistoryService")
public class AgentHistoryServiceImpl extends ServiceImpl<AgentHistoryDao, AgentHistoryEntity> implements AgentHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AgentHistoryEntity> page = this.page(
                new Query<AgentHistoryEntity>().getPage(params),
                new QueryWrapper<AgentHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
