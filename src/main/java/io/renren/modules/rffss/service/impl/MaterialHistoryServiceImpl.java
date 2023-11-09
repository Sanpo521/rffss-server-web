package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.MaterialHistoryDao;
import io.renren.modules.rffss.entity.MaterialHistoryEntity;
import io.renren.modules.rffss.service.MaterialHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("materialHistoryService")
public class MaterialHistoryServiceImpl extends ServiceImpl<MaterialHistoryDao, MaterialHistoryEntity> implements MaterialHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MaterialHistoryEntity> page = this.page(
                new Query<MaterialHistoryEntity>().getPage(params),
                new QueryWrapper<MaterialHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
