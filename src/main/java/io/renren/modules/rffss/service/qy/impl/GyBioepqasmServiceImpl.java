package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyBioepqasmDao;
import io.renren.modules.rffss.entity.qy.GyBioepqasmEntity;
import io.renren.modules.rffss.service.qy.GyBioepqasmService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyBioepqasmService")
public class GyBioepqasmServiceImpl extends ServiceImpl<GyBioepqasmDao, GyBioepqasmEntity> implements GyBioepqasmService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyBioepqasmEntity> page = this.page(
                new Query<GyBioepqasmEntity>().getPage(params),
                new QueryWrapper<GyBioepqasmEntity>()
        );

        return new PageUtils(page);
    }

}
