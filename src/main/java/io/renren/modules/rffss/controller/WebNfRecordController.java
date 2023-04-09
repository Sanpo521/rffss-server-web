package io.renren.modules.rffss.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.config.RffssConfig;
import io.renren.modules.rffss.RffssConstant;
import io.renren.modules.rffss.entity.*;
import io.renren.modules.rffss.service.*;
import io.renren.modules.rffssw.entity.NfUserEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 12:20
 * @desc 备案所有信息控制类
 **/
@RestController
@RequestMapping("wnfrecord")
public class WebNfRecordController {
    @Autowired
    private RffssConfig rffssConfig;
    @Autowired
    private NfBusinService businService;
    @Autowired
    private NfRffsspService rffsspService;
    @Autowired
    private NfAgentService agentService;
    @Autowired
    private NfMaterialService materialService;
    @Autowired
    private NfCheckedService checkedService;
    @Autowired
    private NfRffsspUserService rffsspUserService;
    @Autowired
    private CodeOrganService codeOrganService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("nfrecord:nfjlqjxspzzs:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils businPage = businService.queryPage(params);
        List<NfBusinEntity> businList = (List<NfBusinEntity>) businPage.getList();
        List<NfRecordEntity> recordList = new ArrayList<NfRecordEntity>(5);
        for (NfBusinEntity busin: businList){
            NfRecordEntity record = new NfRecordEntity();
            record.setBusin(busin);
            NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
            record.setRffssp(rffssp);
            NfAgentEntity agent = agentService.getByBusinid(busin.getId());
            record.setAgent(agent);
            List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
            record.setLayout(layouts);
            List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
            record.setIdCardHead(idCardHead);
            List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
            record.setIdCardNe(idCardNe);
            List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
            record.setLetterCommit(letterCommits);
            NfCheckedEntity accept = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_ACCEPT);
            record.setAccept(accept);
            NfCheckedEntity checked = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_CHECKED);
            record.setChecked(checked);
            recordList.add(record);
        }
        businPage.setList(recordList);
        return R.ok().put("page", businPage);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        NfBusinEntity busin = businService.getById(id);
        NfRecordEntity record = new NfRecordEntity();
        record.setBusin(busin);
        NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
        if (null != rffssp.getIssueorg() && StringUtils.isNotEmpty(rffssp.getIssueorg())){
            CodeOrganEntity codeOrgan = codeOrganService.getByCode(rffssp.getIssueorg());
            rffssp.setOrgname(codeOrgan.getName());
        }
        record.setRffssp(rffssp);
        NfAgentEntity agent = agentService.getByBusinid(busin.getId());
        record.setAgent(agent);
        List<NfMaterialEntity> layouts = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LAYOUT);
        record.setLayout(layouts);
        List<NfMaterialEntity> idCardHead = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
        record.setIdCardHead(idCardHead);
        List<NfMaterialEntity> idCardNe = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_IDCARDNE);
        record.setIdCardNe(idCardNe);
        List<NfMaterialEntity> letterCommits = materialService.getsByBusinid(busin.getId(), RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
        record.setLetterCommit(letterCommits);
        NfCheckedEntity accept = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_ACCEPT);
        record.setAccept(accept);
        NfCheckedEntity checked = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_CHECKED);
        record.setChecked(checked);
        return R.ok().put("record", record);
    }

    @RequestMapping("/save")
    public R save(@RequestBody NfRecordEntity record){
        saveRecord(record, RffssConstant.RFFSSP_STATUS_ING, RffssConstant.BUSIN_STATUS_ING);
        return R.ok();
    }

    @RequestMapping("/sumbit")
    public R sumbit(@RequestBody NfRecordEntity record){
        saveRecord(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody NfRecordEntity record){
        saveRecord(record, RffssConstant.RFFSSP_STATUS_ING, RffssConstant.BUSIN_STATUS_ING);

        return R.ok();
    }

    private void saveRecord(NfRecordEntity record,  String rffssStatus, String businStatus){
        NfRffsspEntity rffssp = record.getRffssp();
        if (null != rffssp){
            if (!StringUtils.isNotEmpty(rffssp.getId())){
                rffssp.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
            }
            if (null == rffssp.getCreatetime()){
                rffssp.setCreatetime(new Date());
            }
            rffssp.setLasttime(new Date());
            rffssp.setStatus(rffssStatus);
            rffssp.setValid(1);
            rffsspService.saveOrUpdate(rffssp);
            Long userid = ((NfUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
            NfRffsspUserEntity rffsspUser = rffsspUserService.getByRffssidAndUserid(rffssp.getId(), userid);
            if (null == rffsspUser) {
                rffsspUser = new NfRffsspUserEntity();
                rffsspUser.setUserid(userid);
                rffsspUser.setRffsspid(rffssp.getId());
                rffsspUser.setCreatetime(new Date());
                rffsspUser.setLasttime(new Date());
                rffsspUser.setStatus(1);
                rffsspUserService.saveOrUpdate(rffsspUser);
            }else {
                rffsspUser.setLasttime(new Date());
                rffsspUserService.saveOrUpdate(rffsspUser);
            }
        }
        NfBusinEntity busin = record.getBusin();
        if (null != busin){
            if (!StringUtils.isNotEmpty(busin.getId())){
                busin.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
            }
            busin.setRffsspid(rffssp.getId());
            if (null == busin.getCreatetime()){
                busin.setCreatetime(new Date());
            }
            busin.setLasttime(new Date());
            busin.setStatus(businStatus);
            businService.saveOrUpdate(busin);
        }
        NfAgentEntity agent = record.getAgent();
        if (null != agent && null != agent.getName()){
            if (!StringUtils.isNotEmpty(agent.getId())){
                agent.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
            }
            agent.setBusinid(busin.getId());
            if (null == agent.getCreatetime()){
                agent.setCreatetime(new Date());
            }
            agent.setLasttime(new Date());
            agentService.saveOrUpdate(agent);
        }
        List<NfMaterialEntity> layouts = record.getLayout();
        if (null != layouts && layouts.size()>0){
            int i = 1;
            for (NfMaterialEntity material: layouts){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_LAYOUT);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> idCardHead = record.getIdCardHead();
        if (null != idCardHead && idCardHead.size()>0){
            int i = 1;
            for (NfMaterialEntity material: idCardHead){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_IDCARDHEAD);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> idCardNe = record.getIdCardNe();
        if (null != idCardNe && idCardNe.size()>0){
            int i = 1;
            for (NfMaterialEntity material: idCardNe){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_IDCARDNE);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
        List<NfMaterialEntity> letterCommits = record.getLetterCommit();
        if (null != letterCommits && letterCommits.size()>0){
            int i = 1;
            for (NfMaterialEntity material: letterCommits){
                if (!StringUtils.isNotEmpty(material.getId())){
                    material.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
                }
                material.setMtype(RffssConstant.MATERIAL_TYPE_LETTERCOMMIT);
                material.setName(i++);
                material.setBusinid(busin.getId());
                if (null == material.getCreatetime()){
                    material.setCreatetime(new Date());
                }
                material.setLasttime(new Date());
                materialService.saveOrUpdate(material);
            }
        }
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") String id){
        NfBusinEntity busin = businService.getById(id);
        rffsspService.removeById(busin.getRffsspid());
        agentService.delByBusinid(busin.getId());
        materialService.delByBusinid(busin.getId());
        checkedService.delByBusinid(busin.getId());
        businService.removeById(id);
        return R.ok();
    }
}
