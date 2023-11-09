package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.OptHistoryDao;
import io.renren.modules.rffss.entity.OptHistoryEntity;
import io.renren.modules.rffss.service.OptHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("optHistoryService")
public class OptHistoryServiceImpl extends ServiceImpl<OptHistoryDao, OptHistoryEntity> implements OptHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OptHistoryEntity> page = this.page(
                new Query<OptHistoryEntity>().getPage(params),
                new QueryWrapper<OptHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
