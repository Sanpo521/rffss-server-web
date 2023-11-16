package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.rffss.dao.NfCheckedDao;
import io.renren.modules.rffss.entity.NfAgentEntity;
import io.renren.modules.rffss.entity.NfCheckedEntity;
import io.renren.modules.rffss.service.NfCheckedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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
        queryWrapper.orderByDesc("lasttime");
        List<NfCheckedEntity> checkedEntityList = this.getBaseMapper().selectList(queryWrapper);
        NfCheckedEntity checkedEntity = null;
        if (null != checkedEntityList && checkedEntityList.size()>0){
            checkedEntity = checkedEntityList.get(0);
        }
//        NfCheckedEntity checkedEntity = this.getBaseMapper().(queryWrapper);
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
