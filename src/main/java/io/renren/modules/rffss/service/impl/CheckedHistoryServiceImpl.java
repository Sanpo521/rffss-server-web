package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.CheckedHistoryDao;
import io.renren.modules.rffss.entity.CheckedHistoryEntity;
import io.renren.modules.rffss.service.CheckedHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("checkedHistoryService")
public class CheckedHistoryServiceImpl extends ServiceImpl<CheckedHistoryDao, CheckedHistoryEntity> implements CheckedHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CheckedHistoryEntity> page = this.page(
                new Query<CheckedHistoryEntity>().getPage(params),
                new QueryWrapper<CheckedHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
