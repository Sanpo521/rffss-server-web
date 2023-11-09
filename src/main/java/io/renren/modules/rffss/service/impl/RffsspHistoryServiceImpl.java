package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.RffsspHistoryDao;
import io.renren.modules.rffss.entity.RffsspHistoryEntity;
import io.renren.modules.rffss.service.RffsspHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("rffsspHistoryService")
public class RffsspHistoryServiceImpl extends ServiceImpl<RffsspHistoryDao, RffsspHistoryEntity> implements RffsspHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RffsspHistoryEntity> page = this.page(
                new Query<RffsspHistoryEntity>().getPage(params),
                new QueryWrapper<RffsspHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
