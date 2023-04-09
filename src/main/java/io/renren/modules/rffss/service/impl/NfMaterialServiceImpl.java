package io.renren.modules.rffss.service.impl;

import io.renren.modules.rffss.entity.NfAgentEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfMaterialDao;
import io.renren.modules.rffss.entity.NfMaterialEntity;
import io.renren.modules.rffss.service.NfMaterialService;


@Service("nfMaterialService")
public class NfMaterialServiceImpl extends ServiceImpl<NfMaterialDao, NfMaterialEntity> implements NfMaterialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfMaterialEntity> page = this.page(
                new Query<NfMaterialEntity>().getPage(params),
                new QueryWrapper<NfMaterialEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NfMaterialEntity> getsByBusinid(String businid, String mtype) {
        QueryWrapper queryWrapper = new QueryWrapper<NfMaterialEntity>();
        queryWrapper.eq("businid", businid);
        queryWrapper.eq("mtype", mtype);
        queryWrapper.orderByAsc("morder");
        List<NfMaterialEntity> materialEntities = this.getBaseMapper().selectList(queryWrapper);
        return materialEntities;
    }

    @Override
    public NfMaterialEntity getByBusinid(String businid, String mtype) {
        QueryWrapper queryWrapper = new QueryWrapper<NfMaterialEntity>();
        queryWrapper.eq("businid", businid);
        queryWrapper.eq("mtype", mtype);
        queryWrapper.orderByAsc("morder");
        NfMaterialEntity materialEntity = this.getBaseMapper().selectOne(queryWrapper);
        return materialEntity;
    }

    @Override
    public Integer delByBusinid(String businid) {
        QueryWrapper queryWrapper = new QueryWrapper<NfAgentEntity>();
        queryWrapper.eq("businid", businid);
        Integer result = this.getBaseMapper().delete(queryWrapper);
        return result;
    }
}
