package io.renren.modules.rffss.service.qy.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.qy.GyUploadDao;
import io.renren.modules.rffss.entity.qy.GyUploadEntity;
import io.renren.modules.rffss.service.qy.GyUploadService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("gyUploadService")
public class GyUploadServiceImpl extends ServiceImpl<GyUploadDao, GyUploadEntity> implements GyUploadService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GyUploadEntity> page = this.page(
                new Query<GyUploadEntity>().getPage(params),
                new QueryWrapper<GyUploadEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateUploadType(Long id) {
        if(id!=null){
            UpdateWrapper<GyUploadEntity> up=new UpdateWrapper<>();
            up.eq("id",id).set("type","1");
            update(up);
        }

    }

}
