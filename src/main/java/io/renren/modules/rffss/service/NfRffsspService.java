package io.renren.modules.rffss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.NfRffsspEntity;

import java.util.List;
import java.util.Map;

/**
 * 冷藏冷冻食品贮存服务提供者
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
public interface NfRffsspService extends IService<NfRffsspEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

