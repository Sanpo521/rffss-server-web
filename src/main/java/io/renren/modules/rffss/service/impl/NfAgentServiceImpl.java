package io.renren.modules.rffss.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfAgentDao;
import io.renren.modules.rffss.entity.NfAgentEntity;
import io.renren.modules.rffss.service.NfAgentService;


@Service("nfAgentService")
public class NfAgentServiceImpl extends ServiceImpl<NfAgentDao, NfAgentEntity> implements NfAgentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfAgentEntity> page = this.page(
                new Query<NfAgentEntity>().getPage(params),
                new QueryWrapper<NfAgentEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public NfAgentEntity getByBusinid(String businid) {
        QueryWrapper queryWrapper = new QueryWrapper<NfAgentEntity>();
        queryWrapper.eq("businid", businid);
        NfAgentEntity agentEntity = this.getBaseMapper().selectOne(queryWrapper);
        return agentEntity;
    }

    @Override
    public Integer delByBusinid(String businid) {
        QueryWrapper queryWrapper = new QueryWrapper<NfAgentEntity>();
        queryWrapper.eq("businid", businid);
        Integer result = this.getBaseMapper().delete(queryWrapper);
        return result;
    }
}
