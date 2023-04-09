package io.renren.modules.rffssw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffssw.entity.NfUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NfUserDao  extends BaseMapper<NfUserEntity> {
    /**
     * 根据用户名，查询外网用户
     */
    NfUserEntity queryByUserName(String username);
}
