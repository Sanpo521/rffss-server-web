package io.renren.modules.rffss.service.impl;

import io.renren.modules.rffss.entity.NfBusinEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfBusinDao;
import io.renren.modules.rffss.entity.NfBusinEntity;
import io.renren.modules.rffss.service.NfBusinService;


@Service("nfBusinService")
public class NfBusinServiceImpl extends ServiceImpl<NfBusinDao, NfBusinEntity> implements NfBusinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper<NfBusinEntity>();
        if (params.containsKey("btype")){
            queryWrapper.eq("btype", params.get("btype").toString());
        }
        if (params.containsKey("status")){
            queryWrapper.eq("status", params.get("status").toString());
        }
        queryWrapper.orderByDesc("lasttime");
        IPage<NfBusinEntity> page = this.page(
                new Query<NfBusinEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }
}
