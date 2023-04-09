package io.renren.modules.rffss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffss.entity.CodeAddivEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhaoxiubin
 * create-time 2023-04-05 11:48
 * description 代码集--行政区划DAO
 **/
@Mapper
public interface CodeAddivDao  extends BaseMapper<CodeAddivEntity> {
    /**
     * 根据key，查询value
     */
//    CodeAddivEntity queryByCode(String code);
}
