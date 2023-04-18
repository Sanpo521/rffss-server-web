package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.NfBusinDao;
import io.renren.modules.rffss.entity.NfBusinEntity;
import io.renren.modules.rffss.service.NfBusinService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("nfBusinService")
public class NfBusinServiceImpl extends ServiceImpl<NfBusinDao, NfBusinEntity> implements NfBusinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper queryWrapper = new QueryWrapper<NfBusinEntity>();
        if (params.containsKey("btype")){
            queryWrapper.in("btype",(List)params.get("btype"));
//            queryWrapper.eq("btype", params.get("btype").toString());
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

    @Override
    public PageUtils queryPageIsUserId(Map<String, Object> params, Long userId) {
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        return new PageUtils(baseMapper.queryPageIsUserId(pageParam,userId));
    }


}
