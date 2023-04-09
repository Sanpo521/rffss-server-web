package io.renren.modules.rffss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffss.entity.CodeOrganEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登记机关代码表
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2021-11-08 14:31:41
 */
@Mapper
public interface CodeOrganDao extends BaseMapper<CodeOrganEntity> {
    /**
     * 根据key，查询value
     */
    CodeOrganEntity queryByCode(String code);
}
