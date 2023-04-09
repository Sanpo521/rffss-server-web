package io.renren.modules.rffss.service.impl;

import io.renren.modules.rffss.entity.NfAgentEntity;
import io.renren.modules.rffss.entity.NfMaterialEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfCheckedDao;
import io.renren.modules.rffss.entity.NfCheckedEntity;
import io.renren.modules.rffss.service.NfCheckedService;


@Service("nfCheckedService")
public class NfCheckedServiceImpl extends ServiceImpl<NfCheckedDao, NfCheckedEntity> implements NfCheckedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfCheckedEntity> page = this.page(
                new Query<NfCheckedEntity>().getPage(params),
                new QueryWrapper<NfCheckedEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public NfCheckedEntity getByBusinid(String businid, String ctype) {
        QueryWrapper queryWrapper = new QueryWrapper<NfCheckedEntity>();
        queryWrapper.eq("businid", businid);
        queryWrapper.eq("ctype", ctype);
        NfCheckedEntity checkedEntity = this.getBaseMapper().selectOne(queryWrapper);
        return checkedEntity;
    }

    @Override
    public Integer delByBusinid(String businid) {
        QueryWrapper queryWrapper = new QueryWrapper<NfAgentEntity>();
        queryWrapper.eq("businid", businid);
        Integer result = this.getBaseMapper().delete(queryWrapper);
        return result;
    }
}
