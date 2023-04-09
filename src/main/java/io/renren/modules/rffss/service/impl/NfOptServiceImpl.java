package io.renren.modules.rffss.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.rffss.dao.NfOptDao;
import io.renren.modules.rffss.entity.NfOptEntity;
import io.renren.modules.rffss.service.NfOptService;


@Service("nfOptService")
public class NfOptServiceImpl extends ServiceImpl<NfOptDao, NfOptEntity> implements NfOptService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NfOptEntity> page = this.page(
                new Query<NfOptEntity>().getPage(params),
                new QueryWrapper<NfOptEntity>()
        );

        return new PageUtils(page);
    }

}