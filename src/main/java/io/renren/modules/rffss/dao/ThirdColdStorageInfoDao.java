package io.renren.modules.rffss.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffss.entity.ThirdColdStorageInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * oracle保存
 * @author zzb
 */
@Mapper
public interface ThirdColdStorageInfoDao extends BaseMapper<ThirdColdStorageInfoEntity> {
    List<Map<String,Object>> selectUnb();
}
