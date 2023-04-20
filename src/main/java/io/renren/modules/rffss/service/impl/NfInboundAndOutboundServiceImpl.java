package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.dao.NfInboundAndOutboundDao;
import io.renren.modules.rffss.entity.NfInboundAndOutboundEntity;
import io.renren.modules.rffss.service.NfInboundAndOutboundService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service("nfInboundAndOutboundService")
public class NfInboundAndOutboundServiceImpl extends ServiceImpl<NfInboundAndOutboundDao, NfInboundAndOutboundEntity> implements NfInboundAndOutboundService {


    @Override
    public PageUtils queryPage(Page<NfInboundAndOutboundEntity> pageParam, Long type, String rffsspId) {
        QueryWrapper<NfInboundAndOutboundEntity> query=new QueryWrapper<>();
        if(type!=null){
            query.eq("type",type);
        }
        if(StringUtils.isNotEmpty(rffsspId)){
            query.eq("rffssp_id",rffsspId);
        }
        return new PageUtils(baseMapper.selectPage(pageParam,query));
    }
}