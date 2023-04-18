package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.rffss.entity.NfInboundAndOutboundEntity;
import io.renren.common.utils.PageUtils;


import java.util.Map;

/**
 * 
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-04-18 09:58:55
 */
public interface NfInboundAndOutboundService extends IService<NfInboundAndOutboundEntity> {

    PageUtils queryPage(Page<NfInboundAndOutboundEntity> pageParam,Long type,Long rffsspId);
}

