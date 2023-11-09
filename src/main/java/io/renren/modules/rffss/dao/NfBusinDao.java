package io.renren.modules.rffss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.modules.rffss.entity.NfBusinEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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


    Page<NfBusinEntity> queryPage(Page<NfBusinEntity> pageParam ,@Param("btype")List<String> btype,@Param("issueorg")List<String> issueorg,@Param("status")String status, @Param("createTime") String createTime);

    List<Map<String,Object>> getAddressCodeInbound(@Param("typesOf")String typesOf,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("type") String type);

    Page<Map<String,Object>>queryWarnInbound(Page<Map<String,Object>> pageParam,@Param("date")String date);

    List<Map<String, Object>> listExcel(@Param("btype") List<String> btype, @Param("issueorg") List<String> issueorg, @Param("status") String status, @Param("createTime") String createTime);
}
