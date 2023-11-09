package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.BusinHistoryDao;
import io.renren.modules.rffss.entity.BusinHistoryEntity;
import io.renren.modules.rffss.service.BusinHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("businHistoryService")
public class BusinHistoryServiceImpl extends ServiceImpl<BusinHistoryDao, BusinHistoryEntity> implements BusinHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinHistoryEntity> page = this.page(
                new Query<BusinHistoryEntity>().getPage(params),
                new QueryWrapper<BusinHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
