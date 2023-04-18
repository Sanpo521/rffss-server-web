package io.renren.modules.rffss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.rffss.entity.NfBusinEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 业务表
 * 
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@Mapper
public interface NfBusinDao extends BaseMapper<NfBusinEntity> {
    Page<NfBusinEntity> queryPageIsUserId(Page<NfBusinEntity> pageParam ,@Param("userId")Long userId);
}
