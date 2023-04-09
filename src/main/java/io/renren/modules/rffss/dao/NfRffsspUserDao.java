package io.renren.modules.rffss.dao;

import io.renren.modules.rffss.entity.NfRffsspUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 外网用户与主体关联表
 * 
 * @author zhaoxiubin
 * @email sanpo521@gmail.com
 * @date 2022-11-04 08:54:30
 */
@Mapper
public interface NfRffsspUserDao extends BaseMapper<NfRffsspUserEntity> {
	
}
