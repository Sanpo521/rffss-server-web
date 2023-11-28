package io.renren.modules.rffss.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.dao.NfBusinDao;
import io.renren.modules.rffss.entity.CodeOrganEntity;
import io.renren.modules.rffss.entity.NfBusinEntity;
import io.renren.modules.rffss.service.CodeOrganService;
import io.renren.modules.rffss.service.NfBusinService;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("nfBusinService")
public class NfBusinServiceImpl extends ServiceImpl<NfBusinDao, NfBusinEntity> implements NfBusinService {
    @Autowired
    private CodeOrganService codeOrganService;

    @Override
    public NfBusinEntity queryByRffsspid(String rffsspid){
        List<NfBusinEntity> list = baseMapper.queryByRffsspid(rffsspid);
        NfBusinEntity businEntity = null;
        if (null != list && list.size() > 0){
            businEntity = list.get(0);
        }
        return businEntity;
    }

    @Override
    public PageUtils queryPageEx(Map<String, Object> params) {
        String orgCode = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getOrgcode();
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
            btype=(List)params.get("btype");
        }
        String key = "";
        if (params.containsKey("key")){
            key=params.get("key").toString();
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg") && StrUtil.isNotBlank(params.get("issueorg").toString())){
            CodeOrganEntity codeOrgan = codeOrganService.getById(params.get("issueorg").toString());
            if(codeOrgan!=null){
                issueorg.add(codeOrgan.getCode());
            }
            issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
        }
        String status="";
        if (params.containsKey("status")){
            status=params.get("status").toString();
        }
        return new PageUtils(baseMapper.queryPageEx(pageParam, btype, issueorg, status, key, orgCode));
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String orgCode = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getOrgcode();
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
           btype=(List)params.get("btype");
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg") && StrUtil.isNotBlank(params.get("issueorg").toString())){
            CodeOrganEntity codeOrgan = codeOrganService.getById(params.get("issueorg").toString());
            if(codeOrgan!=null){
                issueorg.add(codeOrgan.getCode());
            }
            issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
        }
        String status="";
        if (params.containsKey("status")){
            status=params.get("status").toString();
        }
        String createTime = "";
        if (params.containsKey("createTime")) {
            createTime = params.get("createTime").toString();
        }
        String applyName = "";
        if (params.containsKey("applyName")) {
            applyName = params.get("applyName").toString();
        }
        String recNum = "";
        if (params.containsKey("recNum")) {
            recNum = params.get("recNum").toString();
        }
        String storageEntName = "";
        if (params.containsKey("storageEntName")) {
            storageEntName = params.get("storageEntName").toString();
        }
        return new PageUtils(baseMapper.queryPage(pageParam,btype,issueorg,status,createTime, applyName, recNum, storageEntName, orgCode));
    }

    @Override
    public PageUtils queryPageByStatisticsExList(Map<String, Object> params) {
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
            btype=(List)params.get("btype");
        }
        String storageEntName = "";
        if (params.containsKey("storageEntName")) {
            storageEntName = params.get("storageEntName").toString();
        }
        String recNum = "";
        if (params.containsKey("recNum")) {
            recNum = params.get("recNum").toString();
        }
        String storageAmount = "";
        if (params.containsKey("storageAmount")) {
            storageAmount = params.get("storageAmount").toString();
        }
        String recTimeBegin = "";
        if (params.containsKey("recTimeBegin")) {
            recTimeBegin = params.get("recTimeBegin").toString();
        }
        String recTimeEnd = "";
        if (params.containsKey("recTimeEnd")) {
            recTimeEnd = params.get("recTimeEnd").toString();
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg") && StrUtil.isNotBlank(params.get("issueorg").toString())){
            CodeOrganEntity codeOrgan = codeOrganService.getById(params.get("issueorg").toString());
            if(codeOrgan!=null){
                issueorg.add(codeOrgan.getCode());
            }
            issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
        }
        String storageProvince="";
        String storageCity="";
        String storageCounty="";
        if (params.containsKey("storageCounty") && params.get("storageCounty").toString().endsWith("0000")){
            storageProvince=params.get("storageCounty").toString();
        }else{
            if (params.containsKey("storageCounty")&& params.get("storageCounty").toString().endsWith("00")){
                storageCity=params.get("storageCounty").toString();
            }else{
                if (params.containsKey("storageCounty")){
                    storageCounty=params.get("storageCounty").toString();
                }
            }
        }
        String status="";
        if (params.containsKey("status")){
            status=params.get("status").toString();
        }
        return new PageUtils(baseMapper.queryPageByStatisticsExList(pageParam, btype, storageEntName,
                recNum, storageAmount, recTimeBegin, recTimeEnd, issueorg, storageProvince, storageCity, storageCounty, status));
    }

    /**
     * 获取当前登记机关下所有登记机关code
     * @param issueorg
     * @param code
     * @param codeOrganService
     * @return
     */
    public static List<String> getCode( List<String> issueorg,String code,CodeOrganService codeOrganService){
        QueryWrapper<CodeOrganEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("parentcode",code);
        List<CodeOrganEntity> list=codeOrganService.list(queryWrapper);
        if(list!=null && !list.isEmpty()){
            for (CodeOrganEntity codeOrgan:list){
                issueorg.add(codeOrgan.getCode());
                issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
            }
        }
        return issueorg;
    };
    @Override
    public PageUtils queryPageIsUserId(Map<String, Object> params, Long userId) {
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        return new PageUtils(baseMapper.queryPageIsUserId(pageParam,userId));
    }

    @Override
    public List<Map<String, Object>> getAddressCodeInbound(String typesOf, String startDate, String endDate,String type) {
        return baseMapper.getAddressCodeInbound(typesOf,startDate,endDate,type);
    }

    @Override
    public PageUtils queryWarnInbound(Long page, Long limit, String date) {
        Page<Map<String,Object>> pageParam=new Page<>(page,limit);
        return new PageUtils(baseMapper.queryWarnInbound(pageParam,date));
    }


    @Override
    public List<Map<String, Object>> listExcel(Map<String, Object> params) {
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
            btype=(List)params.get("btype");
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg") && StrUtil.isNotBlank(params.get("issueorg").toString())){
            CodeOrganEntity codeOrgan = codeOrganService.getById(params.get("issueorg").toString());
            if(codeOrgan!=null){
                issueorg.add(codeOrgan.getCode());
            }
            issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
        }
        String status = "";
        if (params.containsKey("status")) {
            status = params.get("status").toString();
        }

        String recTime = "";
        if (params.containsKey("recTime")) {
            recTime = params.get("recTime").toString();
        }

        return baseMapper.listExcel((List)btype, (List)issueorg, status, recTime);
    }

    @Override
    public List<Map<String, Object>> listExcelByStatisticsExList(Map<String, Object> params) {
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
            btype=(List)params.get("btype");
        }
        String storageEntName = "";
        if (params.containsKey("storageEntName")) {
            storageEntName = params.get("storageEntName").toString();
        }
        String recNum = "";
        if (params.containsKey("recNum")) {
            recNum = params.get("recNum").toString();
        }
        String storageAmount = "";
        if (params.containsKey("storageAmount")) {
            storageAmount = params.get("storageAmount").toString();
        }
        String recTimeBegin = "";
        if (params.containsKey("recTimeBegin")) {
            recTimeBegin = params.get("recTimeBegin").toString();
        }
        String recTimeEnd = "";
        if (params.containsKey("recTimeEnd")) {
            recTimeEnd = params.get("recTimeEnd").toString();
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg") && StrUtil.isNotBlank(params.get("issueorg").toString())){
            CodeOrganEntity codeOrgan = codeOrganService.getById(params.get("issueorg").toString());
            if(codeOrgan!=null){
                issueorg.add(codeOrgan.getCode());
            }
            issueorg= getCode(issueorg,codeOrgan.getCode(),codeOrganService);
        }
        String storageProvince="";
        String storageCity="";
        String storageCounty="";
        if (params.containsKey("storageCounty") && params.get("storageCounty").toString().endsWith("0000")){
            storageProvince=params.get("storageCounty").toString();
        }else{
            if (params.containsKey("storageCounty")&& params.get("storageCounty").toString().endsWith("00")){
                storageCity=params.get("storageCounty").toString();
            }else{
                if (params.containsKey("storageCounty")){
                    storageCounty=params.get("storageCounty").toString();
                }
            }
        }
        String status="";
        if (params.containsKey("status")){
            status=params.get("status").toString();
        }
        return baseMapper.listExcelByStatisticsExList(btype, storageEntName, recNum, storageAmount,
                recTimeBegin, recTimeEnd, issueorg, storageProvince, storageCity, storageCounty, status);
    }

    @Override
    public List<Map<String, Object>> excel(String id) {
        return baseMapper.excel(id);
    }
}
