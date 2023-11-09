package io.renren.modules.rffss.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.config.RffssConfig;
import io.renren.modules.rffss.RffssConstant;
import io.renren.modules.rffss.entity.*;
import io.renren.modules.rffss.service.*;
import io.renren.modules.rffssw.entity.NfUserEntity;
import io.renren.modules.rffssw.entity.UploadEntity;
import io.renren.modules.rffssw.service.UploadService;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    private BusinHistoryService businHistoryService;
    @Autowired
    private NfRffsspService rffsspService;
    @Autowired
    private RffsspHistoryService rffsspHistoryService;
    @Autowired
    private NfAgentService agentService;
    @Autowired
    private AgentHistoryService agentHistoryService;
    @Autowired
    private NfMaterialService materialService;
    @Autowired
    private MaterialHistoryService materialHistoryService;
    @Autowired
    private NfCheckedService checkedService;
    @Autowired
    private NfRffsspUserService rffsspUserService;
    @Autowired
    private CodeOrganService codeOrganService;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private UploadHistoryService uploadHistoryService;
    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("nfrecord:nfjlqjxspzzs:list")
    public R list(@RequestParam Map<String, Object> params){
        Long userid = ((NfUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
        PageUtils businPage = businService.queryPageIsUserId(params,userid);
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
//        record.setBusin(busin);
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
//        NfCheckedEntity accept = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_ACCEPT);
//        record.setAccept(accept);
//        NfCheckedEntity checked = checkedService.getByBusinid(busin.getId(), RffssConstant.CHECKED_TYPE_CHECKED);
//        record.setChecked(checked);
        List<UploadEntity> uploadEntities=uploadService.getUpload(busin.getId(),busin.getBtype());
        record.setUploadEntities(uploadEntities);
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

    private void backupRecord (NfRecordEntity record, String businType){
        NfRffsspEntity rffssp = record.getRffssp();
        if (RffssConstant.BUSIN_STATUS_SUMBIT == businType && null != rffssp && StringUtils.isNotEmpty(rffssp.getId())){
            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(RffsspHistoryEntity.class, NfRffsspEntity.class)
                    .byDefault().register();
            MapperFacade mapper = mapperFactory.getMapperFacade();
            NfRffsspEntity rffsspOld = rffsspService.getById(rffssp.getId());
            RffsspHistoryEntity rffsspHistoryEntity = mapper.map(rffsspOld, RffsspHistoryEntity.class);
            rffsspHistoryEntity.setId(IdWorker.getIdStr());
            rffsspHistoryEntity.setRealid(rffsspOld.getId());
            rffsspHistoryService.saveOrUpdate(rffsspHistoryEntity);

            NfBusinEntity busin = businService.queryByRffsspid(rffssp.getId());
            if (null != busin){
                /***************NfAgentEntity*******************/
                MapperFactory mapperFactoryA = new DefaultMapperFactory.Builder().build();
                mapperFactoryA.classMap(AgentHistoryEntity.class, NfAgentEntity.class)
                        .byDefault().register();
                MapperFacade mapperA = mapperFactoryA.getMapperFacade();
                NfAgentEntity agentOld = agentService.getByBusinid(busin.getId());
                AgentHistoryEntity agentHistoryEntity = mapperA.map(agentOld, AgentHistoryEntity.class);
                agentHistoryEntity.setId(IdWorker.getIdStr());
                agentHistoryEntity.setRealid(agentOld.getId());
                agentHistoryService.saveOrUpdate(agentHistoryEntity);

                /***************List<NfMaterialEntity>*******************/
                MapperFactory mapperFactoryB = new DefaultMapperFactory.Builder().build();
                mapperFactoryB.classMap(MaterialHistoryEntity.class, NfMaterialEntity.class)
                        .byDefault().register();
                MapperFacade mapperB = mapperFactoryB.getMapperFacade();
                List<NfMaterialEntity> nfMaterialEntities = materialService.getsByBusinid(busin.getId());
                if(CollectionUtils.isNotEmpty(nfMaterialEntities)) {
                    for (NfMaterialEntity nf : nfMaterialEntities) {
                        MaterialHistoryEntity materialHistoryEntity = mapperB.map(nf, MaterialHistoryEntity.class);
                        materialHistoryEntity.setId(IdWorker.getIdStr());
                        materialHistoryEntity.setRealid(nf.getId());
                        materialHistoryService.saveOrUpdate(materialHistoryEntity);
                    }
                }
                /***************List<UploadEntity>*******************/
                MapperFactory mapperFactoryC = new DefaultMapperFactory.Builder().build();
                mapperFactoryC.classMap(UploadHistoryEntity.class, UploadEntity.class)
                        .byDefault().register();
                MapperFacade mapperC = mapperFactoryC.getMapperFacade();
                List<UploadEntity> uploadEntities = uploadService.getUpload(busin.getId());
                if(CollectionUtils.isNotEmpty(uploadEntities)) {
                    for (UploadEntity ul : uploadEntities) {
                        UploadHistoryEntity uploadHistory = mapperC.map(ul, UploadHistoryEntity.class);
                        uploadHistory.setId(IdWorker.getId());
                        uploadHistory.setRealid(ul.getId());
                        uploadHistoryService.saveOrUpdate(uploadHistory);
                    }
                }

                /***************NfAgentEntity*******************/
                MapperFactory mapperFactoryD = new DefaultMapperFactory.Builder().build();
                mapperFactoryD.classMap(BusinHistoryEntity.class, NfBusinEntity.class)
                        .byDefault().register();
                MapperFacade mapperD = mapperFactoryD.getMapperFacade();
                BusinHistoryEntity businHistoryEntity = mapperD.map(busin, BusinHistoryEntity.class);
                businHistoryEntity.setId(IdWorker.getIdStr());
                businHistoryEntity.setRealid(busin.getId());
                businHistoryService.saveOrUpdate(businHistoryEntity);
                businService.removeById(busin.getId());
            }
        }
    }

    private void saveRecord(NfRecordEntity record,  String rffssStatus, String businStatus){
        backupRecord(record, businStatus);
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
                rffsspUser.setId(RffssConstant.ID_PREFIX_OUT+IdWorker.getIdStr());
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
            List<UploadEntity> uploadEntities = record.getUploadEntities();
            if(CollectionUtils.isNotEmpty(uploadEntities)){
                for (UploadEntity upload:uploadEntities){
                    upload.setBusiness(busin.getBtype());
                    upload.setBusinessId(busin.getId());
                    upload.setLasttime(new Date());
                    upload.setCreatetime(new Date());
                    uploadService.saveOrUpdate(upload);
                }
            }
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
