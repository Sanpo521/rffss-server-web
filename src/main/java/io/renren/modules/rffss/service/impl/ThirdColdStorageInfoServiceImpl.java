package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.datasource.annotation.DataSource;
import io.renren.modules.rffss.dao.ThirdColdStorageInfoDao;
import io.renren.modules.rffss.entity.ThirdColdStorageInfoEntity;
import io.renren.modules.rffss.service.ThirdColdStorageInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("thirdColdStorageInfoService")
public class ThirdColdStorageInfoServiceImpl extends ServiceImpl<ThirdColdStorageInfoDao, ThirdColdStorageInfoEntity> implements ThirdColdStorageInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ThirdColdStorageInfoEntity> page = this.page(
                new Query<ThirdColdStorageInfoEntity>().getPage(params),
                new QueryWrapper<ThirdColdStorageInfoEntity>()
        );

        return new PageUtils(page);
    }
    @DataSource("oracle22")
    @Override
    public void saveData(ThirdColdStorageInfoEntity thirdColdStorageInfo) {
        baseMapper.insert(thirdColdStorageInfo);
    }
    @Override
    public List<Map<String,Object>> selectUnb(){
        return baseMapper.selectUnb();
    }
}
