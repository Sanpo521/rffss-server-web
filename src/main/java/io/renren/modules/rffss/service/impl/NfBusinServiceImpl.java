package io.renren.modules.rffss.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.modules.rffss.dao.NfBusinDao;
import io.renren.modules.rffss.entity.CodeOrganEntity;
import io.renren.modules.rffss.entity.NfBusinEntity;
import io.renren.modules.rffss.service.CodeOrganService;
import io.renren.modules.rffss.service.NfBusinService;
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
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NfBusinEntity> pageParam = new Page<>(Long.parseLong(params.get("page").toString()), Long.parseLong(params.get("limit").toString()));
        List<String> btype=new ArrayList<>();
        if (params.containsKey("btype")){
           btype=(List)params.get("btype");
        }
        List<String> issueorg=new ArrayList<>();
        if (params.containsKey("issueorg")){
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
        return new PageUtils(baseMapper.queryPage(pageParam,btype,issueorg,status,createTime));
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
        if (params.containsKey("issueorg")){
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

        String createTime = "";
        if (params.containsKey("createTime")) {
            createTime = params.get("createTime").toString();
        }

        return baseMapper.listExcel((List)btype, (List)issueorg, status, createTime);
    }
}
