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

    NfBusinEntity queryByRffsspid(@Param("rffsspid")String rffsspid);

    Page<NfBusinEntity> queryPageIsUserId(Page<NfBusinEntity> pageParam ,@Param("userId")Long userId);

    Page<NfBusinEntity> queryPageEx(Page<NfBusinEntity> pageParam ,
                                    @Param("btype")List<String> btype,
                                    @Param("issueorg")List<String> issueorg,
                                    @Param("status")String status,
                                    @Param("key") String key);

    Page<NfBusinEntity> queryPage(Page<NfBusinEntity> pageParam ,
                                  @Param("btype")List<String> btype,
                                  @Param("issueorg")List<String> issueorg,
                                  @Param("status")String status,
                                  @Param("createTime") String createTime,
                                  @Param("applyName") String applyName,
                                  @Param("recNum") String recNum,
                                  @Param("storageEntName") String storageEntName);

    Page<NfBusinEntity> queryPageByStatisticsExList(Page<NfBusinEntity> pageParam ,
                                                    @Param("btype")List<String> btype,
                                                    @Param("storageEntName") String storageEntName,
                                                    @Param("recNum") String recNum,
                                                    @Param("storageAmount") String storageAmount,
                                                    @Param("recTimeBegin") String recTimeBegin,
                                                    @Param("recTimeEnd") String recTimeEnd,
                                                    @Param("issueorg")List<String> issueorg,
                                                    @Param("storageProvince") String storageProvince,
                                                    @Param("storageCity") String storageCity,
                                                    @Param("storageCounty") String storageCounty,
                                                    @Param("status")String status);

    List<Map<String,Object>> getAddressCodeInbound(@Param("typesOf")String typesOf,@Param("startDate") String startDate,@Param("endDate") String endDate,@Param("type") String type);

    Page<Map<String,Object>>queryWarnInbound(Page<Map<String,Object>> pageParam,@Param("date")String date);

    List<Map<String, Object>> listExcel(@Param("btype") List<String> btype, @Param("issueorg") List<String> issueorg,
                                        @Param("status") String status, @Param("recTime") String recTime);

    List<Map<String, Object>> listExcelByStatisticsExList(@Param("btype")List<String> btype,
                                                          @Param("storageEntName") String storageEntName,
                                                          @Param("recNum") String recNum,
                                                          @Param("storageAmount") String storageAmount,
                                                          @Param("recTimeBegin") String recTimeBegin,
                                                          @Param("recTimeEnd") String recTimeEnd,
                                                          @Param("issueorg")List<String> issueorg,
                                                          @Param("storageProvince") String storageProvince,
                                                          @Param("storageCity") String storageCity,
                                                          @Param("storageCounty") String storageCounty,
                                                          @Param("status")String status);

    List<Map<String, Object>> excel(@Param("id")String id);
}
