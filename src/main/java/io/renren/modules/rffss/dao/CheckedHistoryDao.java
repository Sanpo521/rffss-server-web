package io.renren.modules.rffss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffss.entity.CheckedHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作记录
 *
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2023-11-09 12:38:17
 */
@Mapper
public interface CheckedHistoryDao extends BaseMapper<CheckedHistoryEntity> {

}
