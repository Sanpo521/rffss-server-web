package io.renren.modules.rffssw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.rffssw.entity.NfUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NfUserTokenDao extends BaseMapper<NfUserTokenEntity> {

    NfUserTokenEntity queryByToken(String token);
}
