package io.renren.modules.rffss.service.qy;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.entity.qy.GyEqasmpiEntity;

import java.util.Map;

/**
 *
 *
 * @author zhuzhibo
 * @email zhuzhuboqq.com@qq.com
 * @date 2023-10-23 15:02:42
 */
public interface GyEqasmpiService extends IService<GyEqasmpiEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

