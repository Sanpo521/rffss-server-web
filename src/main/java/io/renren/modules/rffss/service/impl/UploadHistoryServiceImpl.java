package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.UploadHistoryDao;
import io.renren.modules.rffss.entity.UploadHistoryEntity;
import io.renren.modules.rffss.service.UploadHistoryService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("uploadHistoryService")
public class UploadHistoryServiceImpl extends ServiceImpl<UploadHistoryDao, UploadHistoryEntity> implements UploadHistoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UploadHistoryEntity> page = this.page(
                new Query<UploadHistoryEntity>().getPage(params),
                new QueryWrapper<UploadHistoryEntity>()
        );

        return new PageUtils(page);
    }

}
