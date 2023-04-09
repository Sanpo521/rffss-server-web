package io.renren.modules.rffss.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfRffsspUserDao;
import io.renren.modules.rffss.entity.NfRffsspUserEntity;
import io.renren.modules.rffss.service.NfRffsspUserService;


@Service("nfRffsspUserService")
public class NfRffsspUserServiceImpl extends ServiceImpl<NfRffsspUserDao, NfRffsspUserEntity> implements NfRffsspUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfRffsspUserEntity> page = this.page(
                new Query<NfRffsspUserEntity>().getPage(params),
                new QueryWrapper<NfRffsspUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<NfRffsspUserEntity> getByUserid(Long userid) {
        QueryWrapper<NfRffsspUserEntity> queryWrapper = new QueryWrapper<NfRffsspUserEntity>();
        queryWrapper.eq("userid", userid);
        List<NfRffsspUserEntity> list = this.getBaseMapper().selectList(queryWrapper);
        return list;
    }

    @Override
    public List<NfRffsspUserEntity> getByRffssid(String rffssid) {
        QueryWrapper<NfRffsspUserEntity> queryWrapper = new QueryWrapper<NfRffsspUserEntity>();
        queryWrapper.eq("rffsspid", rffssid);
        List<NfRffsspUserEntity> list = this.getBaseMapper().selectList(queryWrapper);
        return list;
    }

    @Override
    public NfRffsspUserEntity getByRffssidAndUserid(String rffssid, Long userid) {
        QueryWrapper<NfRffsspUserEntity> queryWrapper = new QueryWrapper<NfRffsspUserEntity>();
        queryWrapper.eq("rffsspid", rffssid);
        queryWrapper.eq("userid", userid);
        NfRffsspUserEntity rffsspUser = this.getBaseMapper().selectOne(queryWrapper);
        return rffsspUser;
    }
}
