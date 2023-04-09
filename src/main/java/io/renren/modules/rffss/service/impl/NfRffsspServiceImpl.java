package io.renren.modules.rffss.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfRffsspDao;
import io.renren.modules.rffss.entity.NfRffsspEntity;
import io.renren.modules.rffss.service.NfRffsspService;


@Service("nfRffsspService")
public class NfRffsspServiceImpl extends ServiceImpl<NfRffsspDao, NfRffsspEntity> implements NfRffsspService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfRffsspEntity> page = this.page(
                new Query<NfRffsspEntity>().getPage(params),
                new QueryWrapper<NfRffsspEntity>().eq("realid", params.get("id")).orderByDesc("lasttime")
        );

        return new PageUtils(page);
    }
}
