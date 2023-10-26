package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyEqasmpiDao;
import io.renren.modules.rffss.entity.qy.GyEqasmpiEntity;
import io.renren.modules.rffss.service.qy.GyEqasmpiService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyEqasmpiService")
public class GyEqasmpiServiceImpl extends ServiceImpl<GyEqasmpiDao, GyEqasmpiEntity> implements GyEqasmpiService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyEqasmpiEntity> page = this.page(
                new Query<GyEqasmpiEntity>().getPage(params),
                new QueryWrapper<GyEqasmpiEntity>()
        );

        return new PageUtils(page);
    }

}
