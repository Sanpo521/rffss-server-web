package io.renren.modules.rffss.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.config.RffssConfig;
import io.renren.modules.rffss.RffssConstant;
import io.renren.modules.rffss.entity.*;
import io.renren.modules.rffss.service.*;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zhaoxiubin
 * @create 2022-11-05 12:20
 * @desc 备案所有信息控制类
 **/
@RestController
@RequestMapping("nfrecord")
public class NfRecordController {
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

    @RequestMapping("/apply/list")
    @RequiresPermissions("nfrecord:apply:list")
    public R applyList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return list(params);
    }

    @RequestMapping("/change/list")
    @RequiresPermissions("nfrecord:change:list")
    public R changeList(@RequestParam Map<String, Object> params){

        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return list(params);
    }

    @RequestMapping("/cancel/list")
    @RequiresPermissions("nfrecord:cancel:list")
    public R cancelList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ING);
        return list(params);
    }

    @RequestMapping("/applya/list")
    @RequiresPermissions("nfrecord:applya:list")
    public R applyaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/changea/list")
    @RequiresPermissions("nfrecord:changea:list")
    public R changeaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/cancela/list")
    @RequiresPermissions("nfrecord:cancela:list")
    public R cancelaList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_SUMBIT);
        return list(params);
    }

    @RequestMapping("/applyc/list")
    @RequiresPermissions("nfrecord:applyc:list")
    public R applycList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    @RequestMapping("/changec/list")
    @RequiresPermissions("nfrecord:changec:list")
    public R changecList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    @RequestMapping("/cancelc/list")
    @RequiresPermissions("nfrecord:cancelc:list")
    public R cancelcList(@RequestParam Map<String, Object> params){
        List<String> btypes = new ArrayList<>();
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_IN);
        btypes.add(RffssConstant.BUSIN_TYPE_CANCEL_OUT);
        params.put("btype", btypes);
        params.put("status", RffssConstant.BUSIN_STATUS_ACCEPT);
        return list(params);
    }

    @RequestMapping("/check/list")
    @RequiresPermissions("nfrecord:check:list")
    public R checkList(@RequestParam Map<String, Object> params){
        if (params.containsKey("btype")){
            String[] b=params.get("btype").toString().split(",");
            if(b!=null && b.length>0){
                List<String> btypes =  Arrays.asList(b);
                params.put("btype", btypes);
            }
        }else {
            List<String> btypes = new ArrayList<>();
            btypes.add(RffssConstant.BUSIN_TYPE_APPLY_IN);
            btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_IN);
            btypes.add(RffssConstant.BUSIN_TYPE_APPLY_OUT);
            btypes.add(RffssConstant.BUSIN_TYPE_CHANGE_OUT);
            params.put("btype", btypes);
        }
        params.put("status", RffssConstant.BUSIN_STATUS_CHECK);
        return list(params);
    }


    private R list( Map<String, Object> params){
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
    @RequestMapping("/apply/info/{id}")
    @RequiresPermissions("nfrecord:apply:info")
    public R applyInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/change/info/{id}")
    @RequiresPermissions("nfrecord:change:info")
    public R changeInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancel/info/{id}")
    @RequiresPermissions("nfrecord:cancel:info")
    public R cancelInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/applya/info/{id}")
    @RequiresPermissions("nfrecord:applya:info")
    public R applyaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/changea/info/{id}")
    @RequiresPermissions("nfrecord:changea:info")
    public R changeaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancela/info/{id}")
    @RequiresPermissions("nfrecord:cancela:info")
    public R cancelaInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/applyc/info/{id}")
    @RequiresPermissions("nfrecord:applyc:info")
    public R applycInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/changec/info/{id}")
    @RequiresPermissions("nfrecord:changec:info")
    public R changecInfo(@PathVariable("id") String id){
        return info(id);
    }

    /**
     * 信息
     */
    @RequestMapping("/cancelc/info/{id}")
    @RequiresPermissions("nfrecord:cancelc:info")
    public R cancelcInfo(@PathVariable("id") String id){
        return info(id);
    }

    private R info(String id){
        NfBusinEntity busin = businService.getById(id);
        NfRecordEntity record = new NfRecordEntity();
        record.setBusin(busin);
        NfRffsspEntity rffssp = rffsspService.getById(busin.getRffsspid());
        if (null != rffssp.getIssueorg()){
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

    @RequestMapping("/apply/save")
    @RequiresPermissions("nfrecord:apply:save")
    public R applySave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_APPLY_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/change/save")
    @RequiresPermissions("nfrecord:change:save")
    public R changeSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_CHANGE_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancel/save")
    @RequiresPermissions("nfrecord:cancel:save")
    public R cancelSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, RffssConstant.BUSIN_TYPE_CANCEL_IN, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/applya/save")
    @RequiresPermissions("nfrecord:applya:save")
    public R applyaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/changea/save")
    @RequiresPermissions("nfrecord:changea:save")
    public R changeaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancela/save")
    @RequiresPermissions("nfrecord:cancela:save")
    public R cancelaSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/applyc/save")
    @RequiresPermissions("nfrecord:applyc:save")
    public R applycSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/changec/save")
    @RequiresPermissions("nfrecord:changec:save")
    public R changecSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }

    @RequestMapping("/cancelc/save")
    @RequiresPermissions("nfrecord:cancelc:save")
    public R cancelcSave(@RequestBody NfRecordEntity record){
        save(record, RffssConstant.RFFSSP_STATUS_SUMBIT, null, RffssConstant.BUSIN_STATUS_SUMBIT);
        return R.ok();
    }


    private void save (NfRecordEntity record, String rffssStatus, String businType, String businStatus){
        NfRffsspEntity rffssp = record.getRffssp();
        if (null != rffssp){
            if (!StringUtils.isNotEmpty(rffssp.getId())){
                rffssp.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            if (null == rffssp.getCreatetime()){
                rffssp.setCreatetime(new Date());
            }
            rffssp.setLasttime(new Date());
            rffssp.setStatus(rffssStatus);
            rffssp.setValid(1);
            rffsspService.saveOrUpdate(rffssp);
        }
        NfBusinEntity busin = record.getBusin();
        if (null != busin){
            if (!StringUtils.isNotEmpty(busin.getId())){
                busin.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            busin.setRffsspid(rffssp.getId());
            if (null == busin.getCreatetime()){
                busin.setCreatetime(new Date());
            }
            busin.setBtype(null==businType?busin.getBtype():businType);
            busin.setLasttime(new Date());
            busin.setStatus(businStatus);
            businService.saveOrUpdate(busin);
        }
        NfAgentEntity agent = record.getAgent();
        if (null != busin){
            if (!StringUtils.isNotEmpty(agent.getId())){
                agent.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
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
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
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
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
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
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
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
                    material.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
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

        NfCheckedEntity accept = record.getAccept();
        if (null != accept && StringUtils.isNotEmpty(accept.getName())){
//            accept.setId(accept.getId()==0L?null:accept.getId());
            if (!StringUtils.isNotEmpty(accept.getId())){
                accept.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            accept.setCtype(RffssConstant.CHECKED_TYPE_ACCEPT);
            accept.setBusinid(busin.getId());
            if (null == accept.getCreatetime()){
                accept.setCreatetime(new Date());
            }
            accept.setLasttime(new Date());
            if (StringUtils.equals(accept.getCresult(),(RffssConstant.CHECKED_RESULT_NO))){
                rffssp.setStatus(RffssConstant.RFFSSP_STATUS_OVER);
            }
            busin.setStatus(accept.getCtype() + accept.getCresult());
            checkedService.saveOrUpdate(accept);
        }

        NfCheckedEntity checked = record.getChecked();
        if (null != checked && StringUtils.isNotEmpty(checked.getName())){
//            checked.setId(checked.getId()==0L?null:checked.getId());
            if (!StringUtils.isNotEmpty(checked.getId())){
                checked.setId(RffssConstant.ID_PREFIX_IN+IdWorker.getIdStr());
            }
            checked.setCtype(RffssConstant.CHECKED_TYPE_CHECKED);
            checked.setBusinid(busin.getId());
            if (null == checked.getCreatetime()){
                checked.setCreatetime(new Date());
            }
            checked.setLasttime(new Date());
            rffssp.setStatus(RffssConstant.RFFSSP_STATUS_OVER);
            busin.setStatus(checked.getCtype() + checked.getCresult());
            checkedService.saveOrUpdate(checked);
        }
        rffsspService.saveOrUpdate(rffssp);
        businService.saveOrUpdate(busin);
    }

}
